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

import com.intraedge.rating.dto.Weightage;
import com.intraedge.rating.service.WeightageService;

/**
 * weightages resource
 */
@Component
@Path("weightages")
public class WeightageResource {
	@Autowired
	private WeightageService weightageService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Weightage getById(@PathParam("id") long id) {
		Weightage weightage = weightageService.findById(id);
		return weightage;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Weightage> getAll() {
		List<Weightage> weightages = weightageService.findAll();
		return weightages;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(Weightage weightage) {
		long id = weightageService.saveOrUpdate(weightage);
		return Response.status(Response.Status.CREATED)
				.entity("Weightage with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(Weightage weightage) {
		long id = weightageService.saveOrUpdate(weightage);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Weightage with id "+id+" was updated.")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteById(@PathParam("id") long id) {
		weightageService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Weightage with id "+id+" was deleted.")
				.build();
	}
}
