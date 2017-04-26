package org.ogin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Oktavianus on 4/26/2017.
 */
public class Task {
    private long id;
    private String content;

    public Task() {
    }

    public Task(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
