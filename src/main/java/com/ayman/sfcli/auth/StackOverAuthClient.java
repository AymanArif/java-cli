package com.ayman.sfcli.auth;


import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${stackoverflow.auth.client.url}")
public interface StackOverAuthClient {

    @Post(value = "/oauth/access_token/json"
            + "?client_id=${stackoverflow.auth.client.clientId}"
            + "&client_secret=${stackoverflow.auth.client.secret}"
            + "&redirect_uri=${stackoverflow.auth.server.redirectUri}"
            , processes = "application/x-www-form-urlencoded")
    AccessToken accessToken(@QueryValue("code") String code);

}
