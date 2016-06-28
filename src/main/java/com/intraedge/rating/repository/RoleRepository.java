package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByName(String name);
	RoleEntity findByNameLike(String name);
	RoleEntity findByNameStartingWith(String name);
}
