package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
         LOG.info("Hello");
        return "hello";
    }
}