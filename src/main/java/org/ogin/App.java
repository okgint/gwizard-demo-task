package org.ogin;

import com.google.inject.Guice;
import org.gwizard.rest.RestModule;
import org.gwizard.services.Run;
import org.ogin.modules.HelloModule;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Guice.createInjector(new HelloModule(), new RestModule())
                .getInstance(Run.class)
                .start();
    }
}
