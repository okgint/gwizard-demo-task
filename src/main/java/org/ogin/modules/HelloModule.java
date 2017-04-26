package org.ogin.modules;

import com.google.inject.AbstractModule;
import org.ogin.resources.HelloResource;

/**
 * Created by Oktavianus on 4/26/2017.
 */
public class HelloModule extends AbstractModule {
    protected void configure() {
        bind(HelloResource.class);
    }
}
