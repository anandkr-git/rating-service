package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Category;

public interface CategoryService {
	public long saveOrUpdate(Category category);
	public void deleteById(long id);
	public void deleteAll();
	public List<Category> findAll();
	public Category findById(long id);
	public Category findByName(String name);
	public Category findByNameLike(String name);
	public Category findByNameStartingWith(String name);
}
