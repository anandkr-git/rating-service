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

import com.intraedge.rating.dto.Category;
import com.intraedge.rating.service.CategoryService;

/**
 * category resource
 */
@Component
@Path("categories")
public class CategoryResource {
	@Autowired
	private CategoryService categoryService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Category getById(@PathParam("id") long id) {
		Category category = categoryService.findById(id);
		return category;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Category> getAll() {
		List<Category> categorys = categoryService.findAll();
		return categorys;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(Category category) {
		long id = categoryService.saveOrUpdate(category);
		return Response.status(Response.Status.CREATED)
				.entity("Category with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(Category category) {
		long id = categoryService.saveOrUpdate(category);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Category with id "+id+" was updated.")
				.build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteById(@PathParam("id") long id) {
		categoryService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Category with id "+id+" was deleted.")
				.build();
	}
}
