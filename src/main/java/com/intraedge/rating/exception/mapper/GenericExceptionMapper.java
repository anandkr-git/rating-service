package com.intraedge.rating.exception.mapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.intraedge.rating.dto.ErrorResponse;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;

@Service
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setDeveloperMessage(ExceptionUtils.getStackTrace(exception));
		if(exception instanceof EntityNotFoundException){
			errorResponse.setCode(Status.NOT_FOUND.getStatusCode());
		} else if(exception instanceof EntityAlreadyExistsException){
			errorResponse.setCode(Status.CONFLICT.getStatusCode());
		} else if(exception instanceof WebApplicationException){
			errorResponse.setCode(((WebApplicationException)exception).getResponse().getStatus());
		} else {
			errorResponse.setCode(Status.INTERNAL_SERVER_ERROR.getStatusCode());
		}
		return Response.status(errorResponse.getCode())
				.entity(errorResponse)
				.type(MediaType.APPLICATION_XML)
				.build();
	}
}
