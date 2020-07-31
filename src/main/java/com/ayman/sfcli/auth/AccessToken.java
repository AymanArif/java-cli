package com.ayman.sfcli.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
public class AccessToken {

    @JsonProperty("access_token")
    public String token;
}
