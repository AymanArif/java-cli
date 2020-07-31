package com.ayman.sfcli;

import com.ayman.sfcli.auth.AuthCommand;
import com.ayman.sfcli.auth.Credentials;
import com.ayman.sfcli.me.MeCommand;
import com.ayman.sfcli.search.SearchCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "stackoverflow-cli", description = "...",
        mixinStandardHelpOptions = true, subcommands = {SearchCommand.class, AuthCommand.class, MeCommand.class})
public class StackoverflowCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        Credentials.init();
        PicocliRunner.run(StackoverflowCliCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
