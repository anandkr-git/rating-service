package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.GradeEntity;

/**
 * Specifies methods used to obtain and modify Grade entity stored in the database.
 * @author akumar
 */

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
	GradeEntity findByName(String name);
	GradeEntity findByNameLike(String name);
	GradeEntity findByNameStartingWith(String name);
}
