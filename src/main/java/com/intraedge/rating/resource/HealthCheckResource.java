package com.intraedge.rating.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

/**
 * Root resource (exposed at "healthcheck" path)
 */
@Component
@Path("healthcheck")
public class HealthCheckResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response healthCheck() {
        return Response.ok().entity("Ratings web-service is running successfully").build();
    }
}
