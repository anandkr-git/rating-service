package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Skill;

public interface SkillService {
	public long saveOrUpdate(Skill skill);
	public void deleteById(long id);
	public void deleteAll();
	public List<Skill> findAll();
	public Skill findById(long id);
	public Skill findByName(String name);
	public Skill findByNameLike(String name);
	public Skill findByNameStartingWith(String name);
}
