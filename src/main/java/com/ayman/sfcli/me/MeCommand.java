package com.ayman.sfcli.me;


import com.ayman.sfcli.api.StackOverflowHttpClient;
import picocli.CommandLine.Command;

import javax.inject.Inject;

@Command(name = "me")
final public class MeCommand implements Runnable {

    final StackOverflowHttpClient client;

    @Inject
    public MeCommand(StackOverflowHttpClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println(client.me());
        System.exit(0);
    }
}