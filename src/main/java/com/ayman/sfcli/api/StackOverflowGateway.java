package com.ayman.sfcli.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

/**
 * Micronaut's HTTP Client Interface
 * @author Patel, Ayman
 */
@Client("${stackoverflow.api.url}")
public interface StackOverflowGateway {

    @Get("/search?site=stackoverflow")
    ApiResponse<Question> search (
            @QueryValue("intitle") String query,
            @QueryValue("tag") String tag,
            @QueryValue("pagesize") int limit,
            @QueryValue("sort") String sort
    );
}
