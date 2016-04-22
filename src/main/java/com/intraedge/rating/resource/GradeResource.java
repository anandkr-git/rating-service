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

import com.intraedge.rating.dto.Grade;
import com.intraedge.rating.service.GradeService;

/**
 * grades resource
 */
@Component
@Path("grades")
public class GradeResource {
	@Autowired
	private GradeService gradeService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Grade getById(@PathParam("id") long id) {
		Grade grade = gradeService.findById(id);
		return grade;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Grade> getAll() {
		List<Grade> grades = gradeService.findAll();
		return grades;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(Grade grade) {
		long id = gradeService.saveOrUpdate(grade);
		return Response.status(Response.Status.CREATED)
				.entity("Grade with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(Grade grade) {
		long id = gradeService.saveOrUpdate(grade);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Grade with id "+id+" was updated.")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteById(@PathParam("id") long id) {
		gradeService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Grade with id "+id+" was deleted.")
				.build();
	}
}
