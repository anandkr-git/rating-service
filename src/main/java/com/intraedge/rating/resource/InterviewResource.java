package com.intraedge.rating.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intraedge.rating.dto.Interview;
import com.intraedge.rating.service.InterviewService;

@Component
@Path("interviews")
public class InterviewResource {

	@Autowired
	private InterviewService interviewService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Interview getById(@PathParam("id") long id) {
		Interview interview = interviewService.findById(id);
		return interview;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Interview> getAll() {
		List<Interview> interviews = interviewService.findAll();
		return interviews;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(Interview interview) {
		long id = interviewService.saveOrUpdate(interview);
		return Response.status(Response.Status.CREATED)
				.entity("Interview with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(Interview interview) {
		long id = interviewService.saveOrUpdate(interview);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Interview with id "+id+" was updated.")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteById(@PathParam("id") long id) {
		interviewService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Interview with id "+id+" was deleted.")
				.build();
	}
	
}
