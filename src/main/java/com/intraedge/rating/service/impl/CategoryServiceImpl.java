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
import com.intraedge.rating.dto.Category;
import com.intraedge.rating.entity.CategoryEntity;
import com.intraedge.rating.exception.EntityAlreadyExistsException;
import com.intraedge.rating.exception.EntityNotFoundException;
import com.intraedge.rating.repository.CategoryRepository;
import com.intraedge.rating.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public long saveOrUpdate(Category category) {
		CategoryEntity entity = (CategoryEntity)EntityBuilder.build(category);
		try {
			entity = categoryRepository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new EntityAlreadyExistsException("The entity Category with the name ["+category.getName()+"] is already present.", e);
		}
		return entity.getId();
	}

	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteById(long id) {
		try {
			categoryRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Could not delete, because the entity category with id ["+id+"] does not exist or was already deleted ",  e);
		}
	}
	
	@Override
	@Transactional(propagation  = Propagation.REQUIRED)
	public void deleteAll(){
		categoryRepository.deleteAll();
	}
	
	@Override
	@Transactional(readOnly  = true)
	public List<Category> findAll(){
		List<CategoryEntity> categoryEntities = categoryRepository.findAll();
		List<Category> categorys = new ArrayList<Category>();
		for(CategoryEntity entity: categoryEntities){
			categorys.add((Category)DtoBuilder.build(entity));
		}
		return categorys;
	}

	@Override
	@Transactional(readOnly  = true)
	public Category findById(long id) {
		CategoryEntity entity = categoryRepository.findOne(id);
		return (Category)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Category findByName(String name) {
		CategoryEntity entity = categoryRepository.findByName(name);
		return (Category)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Category findByNameLike(String name) {
		CategoryEntity entity = categoryRepository.findByNameLike(name);
		return (Category)DtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly  = true)
	public Category findByNameStartingWith(String name) {
		CategoryEntity entity = categoryRepository.findByNameStartingWith(name);
		return (Category)DtoBuilder.build(entity);
	}

}
