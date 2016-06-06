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
import com.intraedge.rating.dto.Interview;
import com.intraedge.rating.entity.InterviewEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.InterviewRepository;
import com.intraedge.rating.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired
	InterviewRepository interviewRepository;

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(Interview interview) {
		InterviewEntity entity = (InterviewEntity)EntityBuilder.build(interview);
		try {
			entity = interviewRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new EntityAlreadyExistsException("The entity Interview with the name ["+interview.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteById(long id) {
		try {
			interviewRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because the entity interview with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteAll() {
		interviewRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly  = true)
	public List<Interview> findAll() {
		List<InterviewEntity> interviewEntities = interviewRepository.findAll();
		List<Interview> interviews = new ArrayList<Interview>();
		for(InterviewEntity entity: interviewEntities){
			interviews.add((Interview)DtoBuilder.build(entity));
		}
		return interviews;
	}

	@Override
	@Transactional(readOnly  = true)
	public Interview findById(long id) {
		InterviewEntity entity = interviewRepository.findOne(id);
		return (Interview)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Interview findByName(String name) {
		InterviewEntity entity = interviewRepository.findByName(name);
		return (Interview)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Interview findByNameLike(String name) {
		InterviewEntity entity = interviewRepository.findByNameLike(name);
		return (Interview)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Interview findByNameStartingWith(String name) {
		InterviewEntity entity = interviewRepository.findByNameStartingWith(name);
		return (Interview)DtoBuilder.build(entity);
	}

}
