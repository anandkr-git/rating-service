package com.intraedge.rating.service;

import java.util.List;

import com.intraedge.rating.dto.Role;

public interface RoleService {
	public long saveOrUpdate(Role role);
	public void deleteById(long id);
	public void deleteAll();
	public List<Role> findAll();
	public Role findById(long id);
	public Role findByName(String name);
	public Role findByNameLike(String name);
	public Role findByNameStartingWith(String name);
}
