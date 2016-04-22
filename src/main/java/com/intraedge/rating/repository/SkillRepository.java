package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.SkillEntity;

/**
 * Specifies methods used to obtain and modify Skill entity stored in the database.
 * @author akumar
 */

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
	SkillEntity findByName(String name);
	SkillEntity findByNameLike(String name);
	SkillEntity findByNameStartingWith(String name);
}
