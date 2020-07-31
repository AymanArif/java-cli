package com.ayman.sfcli.search;


import com.ayman.sfcli.api.ApiResponse;
import com.ayman.sfcli.api.Question;
import com.ayman.sfcli.api.StackOverflowGateway;
import com.ayman.sfcli.api.StackOverflowJavaHTTPClient;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Help.Ansi;

import javax.inject.Inject;

/**
 * Custom `stackoverflow` command
 * NOTE: This class has to be passed to base class @link{StackOverCliCommand} under subcommands configuration
 */
@Command(name="search", description = "Search through stackoverflow questions", mixinStandardHelpOptions = true)
public class SearchCommand implements Runnable{

    @Option(names= {"-q", "--query"}, description = "Search phrase!") // -q Shorthand; --q: Longhand
    String query = "";

    @Option(names = {"-t", "--tag"}, description = "Search inside specific tag")
    String tag = "";

    @Option(names = {"-n", "--limit"}, description = "Limit results. Default: 10")
    int limit = 10;

    @Option(names = {"-s", "--sort-by"}, description = "Sorting filters: relevance, votes, creation, activity. Default: relevance")
    String sort = "relevance";

    @Option(names = {"--verbose"}, description = "Verbose output.")
    boolean verbose;

    @Inject
    StackOverflowGateway client;

    @Inject
    StackOverflowJavaHTTPClient request;

    @Override
    public void run() {

        //System.out.println("Search command CLI... ");
        //var response = client.search(query, tag, limit, sort);
        var response = request.execute(query, tag, limit, sort);


        response.items.stream()
                .map(SearchCommand::formatQuestion)
                .forEach(System.out::println);

        if (verbose) {
            System.out.printf("\n Items size: %d | Quota max: %d | Quota remaining: %d | Has more: %s\n",
                                response.items.size(),
                                response.quotaMax,
                                response.quotaRemaining,
                                response.hasMore
                            );
        }
    }

    static private String formatQuestion(final Question question) {
        return Ansi.AUTO.string(String.format(
                "@|bold,fg(green)  %s|@ %d|%d @|bold,fg(yellow) %s|@\n      %s",
                question.accepted ? "✔":"" ,
                question.score,
                question.answers,
                question.title,
                question.link
                ));
    }
}
