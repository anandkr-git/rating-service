package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.InterviewEntity;


@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity, Long> {
	InterviewEntity findByName(String name);
	InterviewEntity findByNameLike(String name);
	InterviewEntity findByNameStartingWith(String name);
}
