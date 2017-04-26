package org.ogin;

import com.google.inject.Guice;
import org.gwizard.config.ConfigModule;
import org.gwizard.rest.RestModule;
import org.gwizard.services.Run;
import org.ogin.config.TaskConfig;
import org.ogin.modules.TaskModule;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Oktavianus on 4/26/2017.
 */
public class TaskMain {
    public static void main(String[] args) {
        String file = null;
        //            file = TaskMain.class.getClassLoader().getResource("TaskConfig.yaml").toURI().getPath();
//            System.out.println(file);
        Guice.createInjector(new TaskModule(), new ConfigModule(new File("D:\\TaskConfig.yml"), TaskConfig.class), new RestModule())
                .getInstance(Run.class)
                .start();

    }
}
