package org.art.web.ws.rs.messenger.exceptions;

import org.art.web.ws.rs.messenger.models.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), Response.Status.NOT_FOUND.getStatusCode(), "URL");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}
