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
import com.intraedge.rating.dto.Grade;
import com.intraedge.rating.entity.GradeEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.GradeRepository;
import com.intraedge.rating.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(Grade grade) {
		GradeEntity entity = (GradeEntity)EntityBuilder.build(grade);
		try {
			entity = gradeRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new EntityAlreadyExistsException("The entity Grade with the name ["+grade.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteById(long id) {
		try {
			gradeRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because entity grade with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteAll(){
		gradeRepository.deleteAll();
	}
	
	@Override
	@Transactional(readOnly  = true)
	public List<Grade> findAll(){
		List<GradeEntity> gradeEntities = gradeRepository.findAll();
		List<Grade> grades = new ArrayList<Grade>();
		for(GradeEntity entity: gradeEntities){
			grades.add((Grade)DtoBuilder.build(entity));
		}
		return grades;
	}

	@Override
	@Transactional(readOnly  = true)
	public Grade findById(long id) {
		GradeEntity entity = gradeRepository.findOne(id);
		return (Grade)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Grade findByName(String name) {
		GradeEntity entity = gradeRepository.findByName(name);
		return (Grade)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Grade findByNameLike(String name) {
		GradeEntity entity = gradeRepository.findByNameLike(name);
		return (Grade)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Grade findByNameStartingWith(String name) {
		GradeEntity entity = gradeRepository.findByNameStartingWith(name);
		return (Grade)DtoBuilder.build(entity);
	}

}
