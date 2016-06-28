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

import com.intraedge.rating.dto.Role;
import com.intraedge.rating.service.RoleService;

@Component
@Path("roles")
public class RoleResource {

	@Autowired
	private RoleService roleService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Role getRole(@PathParam("id")long id){
		Role role = roleService.findById(id);
		return role;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Role> getRoles(){
		List<Role> roles = roleService.findAll();
		return roles;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(Role role){
		long id = roleService.saveOrUpdate(role);
		return Response.status(Response.Status.CREATED)
				.entity("Role with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(Role role){
		long id = roleService.saveOrUpdate(role);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Role with id "+id+" was updated.")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response delete(@PathParam("id")long id){
		roleService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Role with id "+id+" was deleted.")
				.build();
	}
}
