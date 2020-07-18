package com.ayman.sfcli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.util.Collections;
import java.util.List;

/**
 * TODO: Remove Introspected and see how this fails
 * An annotation that indicates a type should produce a {@link io.micronaut.core.beans.BeanIntrospection} at compilation time.
 * Requiore this for transforming JSON to Jackson without reflection
 */
@Introspected
public final class ApiResponse<T> {

    public List<Question> items = Collections.emptyList(); // TODO: Collections.* vs Arrays.asList()

    @JsonProperty("has_more")
    public boolean hasMore;

    @JsonProperty("quota_max")
    public int quotaMax;

    @JsonProperty("quota_remaining")
    public int quotaRemaining;


    @Override
    public String toString() {
        return "ApiResponse{" +
                "items=" + items +
                ", hasMore=" + hasMore +
                ", quotaMax=" + quotaMax +
                ", quotaRemaining=" + quotaRemaining +
                '}';
    }
}
