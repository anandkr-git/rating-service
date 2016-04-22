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

import com.intraedge.rating.dto.Skill;
import com.intraedge.rating.service.SkillService;

/**
 * skills resource
 */
@Component
@Path("skills")
public class SkillResource {
	@Autowired
	private SkillService skillService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Skill getById(@PathParam("id") long id) {
		Skill skill = skillService.findById(id);
		return skill;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Skill> getAll() {
		List<Skill> skills = skillService.findAll();
		return skills;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(Skill skill) {
		long id = skillService.saveOrUpdate(skill);
		return Response.status(Response.Status.CREATED)
				.entity("Skill with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(Skill skill) {
		long id = skillService.saveOrUpdate(skill);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Skill with id "+id+" was updated.")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteById(@PathParam("id") long id) {
		skillService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Skill with id "+id+" was deleted.")
				.build();
	}
}
