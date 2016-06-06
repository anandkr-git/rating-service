package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.InterviewDetailsEntity;;

@Repository
public interface InterviewDetailsRepository extends JpaRepository<InterviewDetailsEntity, Long>{

}
