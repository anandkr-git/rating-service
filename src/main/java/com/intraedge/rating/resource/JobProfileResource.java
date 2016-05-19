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

import com.intraedge.rating.dto.JobProfile;
import com.intraedge.rating.service.JobProfileService;

@Component
@Path("jobprofiles")
public class JobProfileResource {

	@Autowired
	JobProfileService jobProfileService;
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<JobProfile> getAll(){
		List<JobProfile> jobProfile = (List<JobProfile>) jobProfileService.findAll();
		return jobProfile;
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public JobProfile getById(@PathParam("id") int id){
		JobProfile jobProfile = (JobProfile) jobProfileService.findById(id);
		return jobProfile;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response add(JobProfile jobProfile) {
		long id = jobProfileService.saveOrUpdate(jobProfile);
		return Response.status(Response.Status.CREATED)
				.entity("Job Profile with id "+id+" was created.")
				.header("created-entity-id", id)
				.build();
	} 
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_PLAIN})
	public Response update(JobProfile jobProfile) {
		long id = jobProfileService.saveOrUpdate(jobProfile);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Job Profile with id "+id+" was updated.")
				.build();
	} 
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response delete(@PathParam("id")int id){
		jobProfileService.deleteById(id);
		return Response.status(Response.Status.ACCEPTED)
				.entity("Job Profile with id "+id+" was deleted.")
				.build();
	}
	
}
