package org.art.web.ws.rs.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DemoResource {

    @GET
    @Path("/annotations")
    public String getParamByAnnotation(@MatrixParam("param") String matrixParam,
                                       @HeaderParam("Custom-Header") String header,
                                       @CookieParam("Cookie-name") String cookie) {
        return "Matrix param: " + matrixParam + ", header param: " + header + ", cookie: " + cookie;
    }

    @GET
    @Path("/context")
    public String getParamsByContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "Absolute path: " + path + ", cookies: " + cookies;
    }
}
