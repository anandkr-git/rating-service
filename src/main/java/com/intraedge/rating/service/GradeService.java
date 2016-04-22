package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Grade;

public interface GradeService {
	public long saveOrUpdate(Grade grade);
	public void deleteById(long id);
	public void deleteAll();
	public List<Grade> findAll();
	public Grade findById(long id);
	public Grade findByName(String name);
	public Grade findByNameLike(String name);
	public Grade findByNameStartingWith(String name);
}
