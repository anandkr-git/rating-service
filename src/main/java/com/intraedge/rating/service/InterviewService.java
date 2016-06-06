package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Interview;

public interface InterviewService {
	
	public long saveOrUpdate(Interview interview);
	public void deleteById(long id);
	public void deleteAll();
	public List<Interview> findAll();
	public Interview findById(long id);
	public Interview findByName(String name);
	public Interview findByNameLike(String name);
	public Interview findByNameStartingWith(String name);

}
