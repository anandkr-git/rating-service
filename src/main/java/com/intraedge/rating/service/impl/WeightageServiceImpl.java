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
import com.intraedge.rating.dto.Weightage;
import com.intraedge.rating.entity.WeightageEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.WeightageRepository;
import com.intraedge.rating.service.WeightageService;

@Service
public class WeightageServiceImpl implements WeightageService {

	@Autowired
	WeightageRepository weightageRepository;
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(Weightage weightage) {
		WeightageEntity entity = (WeightageEntity)EntityBuilder.build(weightage);
		try {
			entity = weightageRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new EntityAlreadyExistsException("The entity Weightage with the name ["+weightage.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteById(long id) {
		try {
			weightageRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because entity weightage with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteAll(){
		weightageRepository.deleteAll();
	}
	
	@Override
	@Transactional(readOnly  = true)
	public List<Weightage> findAll(){
		List<WeightageEntity> weightageEntities = weightageRepository.findAll();
		List<Weightage> weightages = new ArrayList<Weightage>();
		for(WeightageEntity entity: weightageEntities){
			weightages.add((Weightage)DtoBuilder.build(entity));
		}
		return weightages;
	}

	@Override
	@Transactional(readOnly  = true)
	public Weightage findById(long id) {
		WeightageEntity entity = weightageRepository.findOne(id);
		return (Weightage)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Weightage findByName(String name) {
		WeightageEntity entity = weightageRepository.findByName(name);
		return (Weightage)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Weightage findByNameLike(String name) {
		WeightageEntity entity = weightageRepository.findByNameLike(name);
		return (Weightage)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Weightage findByNameStartingWith(String name) {
		WeightageEntity entity = weightageRepository.findByNameStartingWith(name);
		return (Weightage)DtoBuilder.build(entity);
	}

}
