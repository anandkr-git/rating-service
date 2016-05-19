package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Category;
import com.intraedge.rating.dto.JobProfile;

public interface JobProfileService {

	public long saveOrUpdate(JobProfile jobProfile);
	public void deleteById(long id);
	public void deleteAll();
	public List<JobProfile> findAll();
	public JobProfile findById(long id);
	public JobProfile findByName(String name);
	public JobProfile findByNameLike(String name);
	public JobProfile findByNameStartingWith(String name);
}
