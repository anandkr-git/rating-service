package com.intraedge.rating.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intraedge.rating.builder.DtoBuilder;
import com.intraedge.rating.builder.EntityBuilder;
import com.intraedge.rating.dto.Skill;
import com.intraedge.rating.entity.SkillEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.SkillRepository;
import com.intraedge.rating.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillRepository skillRepository;
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(Skill skill) {
		SkillEntity entity = (SkillEntity)EntityBuilder.build(skill);
		try {
			entity = skillRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new EntityAlreadyExistsException("The entity Skill with the name ["+skill.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteById(long id) {
		try {
			skillRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because entity skill with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteAll(){
		skillRepository.deleteAll();
	}
	
	@Override
	@Transactional(readOnly  = true)
	public List<Skill> findAll(){
		List<SkillEntity> skillEntities = skillRepository.findAll();
		List<Skill> skills = new ArrayList<Skill>();
		for(SkillEntity entity: skillEntities){
			skills.add((Skill)DtoBuilder.build(entity));
		}
		return skills;
	}

	@Override
	@Transactional(readOnly  = true)
	public Skill findById(long id) {
		SkillEntity entity = skillRepository.findOne(id);
		return (Skill)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Skill findByName(String name) {
		SkillEntity entity = skillRepository.findByName(name);
		return (Skill)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Skill findByNameLike(String name) {
		SkillEntity entity = skillRepository.findByNameLike(name);
		return (Skill)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Skill findByNameStartingWith(String name) {
		SkillEntity entity = skillRepository.findByNameStartingWith(name);
		return (Skill)DtoBuilder.build(entity);
	}

}
