package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.intraedge.rating.entity.JobProfileEntity;

@Repository
public interface JobProfileRepository extends JpaRepository<JobProfileEntity, Long> {
	
	JobProfileEntity findByName(String name);
	JobProfileEntity findByNameLike(String name);
	JobProfileEntity findByNameStartingWith(String name);
}
