package org.ogin.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Oktavianus on 4/26/2017.
 */
@Path("/hello")
public class HelloResource {
    @GET
    public String hello() {
        return "Hello, World";
    }

}
