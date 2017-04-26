package org.ogin.resources;

import com.codahale.metrics.annotation.Timed;
import org.ogin.config.TaskConfig;
import org.ogin.entity.Task;
import org.ogin.util.OptionalTask;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ogin
 */
@Path("/task-list")
public class TaskListResource {
    private final int maxLength;
    private final AtomicLong counter;

    @Inject
    public TaskListResource(TaskConfig config) {
        this.maxLength = config.getMaxLength();
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public List<Task> listTasks(@QueryParam("contains") OptionalTask contains) {
        List<Task> tasks = new ArrayList<>();
        String query = contains.getContains().orElse("");
        List<String> lines = new ArrayList<>();

        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        OSProcess proc[] = os.getProcesses(0, null);
        for(int i=0; i < proc.length; i++) {
            lines.add(proc[i].getName());
        }
        for(int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            //filter the processes depending on the ?contains= from the url
            if(line.contains(query)) {
                //trim the processes according to the maxLength
                tasks.add(new Task(counter.getAndIncrement(), line.substring(0, Math.min(line.length(), maxLength))));
            }
        }
        return tasks;
    }
}
