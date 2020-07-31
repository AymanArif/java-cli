package com.ayman.sfcli.auth;

import com.sun.net.httpserver.HttpServer;

import javax.inject.Inject;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class AuthHttpServer {

    final ServerConfiguration config;
    final StackOverAuthClient authClient;

    @Inject
    public AuthHttpServer(ServerConfiguration config, StackOverAuthClient authClient) {
        this.config = config;
        this.authClient = authClient;
    }

    void start() {
        try {
            var latch = new CountDownLatch(1);
            var server = HttpServer.create(new InetSocketAddress(config.getHost(), config.getPort()), 0);
            server.createContext(config.getContext(), exchange -> {
                var code = exchange.getRequestURI().toString().split("=")[1];
                System.out.println("Code retrieved." + code);

                var accessToken = authClient.accessToken(code);
                System.out.println("AccessToken Revieved!");
                System.out.println("access+token=" + accessToken .token);

                var response = "Success! Authentication completed. You can close web browser and return to the terminal window.";


                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes(StandardCharsets.UTF_8));

                latch.countDown();
            });
            server.start();
            System.out.println("Waiting for redirect URI...");
            latch.await(config.getTimeout(), TimeUnit.SECONDS);
            server.stop(0);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
