package org.ogin.modules;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.jackson.Jackson;
import org.ogin.config.TaskConfig;
import org.ogin.resources.TaskListResource;

/**
 * Created by Oktavianus on 4/26/2017.
 */
public class TaskModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TaskListResource.class);
    }

    @Provides
    @Singleton
    public ObjectMapper objectMapper() {
        return Jackson.newObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    @Provides
    public int getMaxLength(TaskConfig taskConfig) {
        return taskConfig.getMaxLength();
    }
}
