package org.bbva.kidsbankingapp.utils;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;;

public class ServiceExceptionHandler implements ExceptionMapper<ServiceException> 
{
    @Override
    public Response toResponse(ServiceException exception) 
    {
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();  
    }
}