package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.WeightageEntity;

/**
 * Specifies methods used to obtain and modify Weightage entity stored in the database.
 * @author akumar
 */

@Repository
public interface WeightageRepository extends JpaRepository<WeightageEntity, Long> {
	WeightageEntity findByName(String name);
	WeightageEntity findByNameLike(String name);
	WeightageEntity findByNameStartingWith(String name);
}
