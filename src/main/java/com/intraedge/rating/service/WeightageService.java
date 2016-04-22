package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Weightage;

public interface WeightageService {
	public long saveOrUpdate(Weightage weightage);
	public void deleteById(long id);
	public void deleteAll();
	public List<Weightage> findAll();
	public Weightage findById(long id);
	public Weightage findByName(String name);
	public Weightage findByNameLike(String name);
	public Weightage findByNameStartingWith(String name);
}
