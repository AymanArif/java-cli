package com.ayman.sfcli.auth;


import picocli.CommandLine.Command;

import javax.inject.Inject;

@Command(name = "auth")
final public class AuthCommand implements Runnable{

    final ClientConfiguration clientConfiguration;

    @Inject
    public AuthCommand(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
    }


    @Override
    public void run() {
        displayAuthUrl();
        //handleRedirectUri();
    }


    private void displayAuthUrl() {
        System.out.println("Click on the link to start authentication");
        System.out.println(clientConfiguration.generateAuthUri("http://localhost"));
        //System.out.println(clientConfiguration.generateAuthUri(authHttpServer.config.getRedirectUri()));

    }
}
