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
import com.intraedge.rating.dto.Role;
import com.intraedge.rating.entity.GradeEntity;
import com.intraedge.rating.entity.RoleEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.RoleRepository;
import com.intraedge.rating.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(Role role) {
		RoleEntity entity = (RoleEntity)EntityBuilder.build(role);
		try {
			entity = roleRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new EntityAlreadyExistsException("The entity Role with the name ["+role.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteById(long id) {
		try {
			roleRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because entity role with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteAll() {
		roleRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly  = true)
	public List<Role> findAll() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		List<Role> roles = new ArrayList<Role>();
		for(RoleEntity entity: roleEntities){
			roles.add((Role)DtoBuilder.build(entity));
		}
		return roles;
	}

	@Override
	@Transactional(readOnly  = true)
	public Role findById(long id) {
		RoleEntity entity = roleRepository.findOne(id);
		return (Role)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Role findByName(String name) {
		RoleEntity entity = roleRepository.findByName(name);
		return (Role)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Role findByNameLike(String name) {
		RoleEntity entity = roleRepository.findByNameLike(name);
		return (Role)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Role findByNameStartingWith(String name) {
		RoleEntity entity = roleRepository.findByNameStartingWith(name);
		return (Role)DtoBuilder.build(entity);
	}

}
