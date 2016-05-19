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
import com.intraedge.rating.dto.JobProfile;
import com.intraedge.rating.entity.JobProfileEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.JobProfileRepository;
import com.intraedge.rating.service.JobProfileService;

@Service
public class JobProfileServiceImpl implements JobProfileService{

	@Autowired
	JobProfileRepository jobProfileRepository;
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(JobProfile jobProfile) {
		JobProfileEntity entity = (JobProfileEntity)EntityBuilder.build(jobProfile);
		try {
			entity = jobProfileRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new EntityAlreadyExistsException("The entity Job Profile with the name ["+jobProfile.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(long id) {
		try{
			jobProfileRepository.delete(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because the entity Job profile with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteAll() {
		jobProfileRepository.deleteAll();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public List<JobProfile> findAll() {
		List<JobProfileEntity> jobProfileEntities = jobProfileRepository.findAll();
		List<JobProfile> jobProfiles = new ArrayList<JobProfile>();
		
		for(JobProfileEntity jobProfileEntity : jobProfileEntities){
			JobProfile jProfile = (JobProfile) DtoBuilder.build(jobProfileEntity);
			jobProfiles.add(jProfile);
		}
		return jobProfiles;
	}

	@Override
	@Transactional(readOnly  = true)
	public JobProfile findById(long id) {
		JobProfileEntity entity = jobProfileRepository.findOne(id);
		return (JobProfile)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public JobProfile findByName(String name) {
		JobProfileEntity entity = jobProfileRepository.findByName(name);
		return (JobProfile)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public JobProfile findByNameLike(String name) {
		JobProfileEntity entity = jobProfileRepository.findByNameLike(name);
		return (JobProfile)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public JobProfile findByNameStartingWith(String name) {
		JobProfileEntity entity = jobProfileRepository.findByNameStartingWith(name);
		return (JobProfile)DtoBuilder.build(entity);
	}

}
