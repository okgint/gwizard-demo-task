package org.ogin.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Oktavianus on 4/26/2017.
 */
public class TaskConfig {
    private int maxLength;

    public TaskConfig() {
    }
    @JsonProperty
    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
