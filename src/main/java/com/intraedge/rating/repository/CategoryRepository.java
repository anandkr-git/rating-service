package com.intraedge.rating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraedge.rating.entity.CategoryEntity;

/**
 * Specifies methods used to obtain and modify category entity stored in the database.
 * @author akumar
 */

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	CategoryEntity findByName(String name);
	CategoryEntity findByNameLike(String name);
	CategoryEntity findByNameStartingWith(String name);
}
