package com.intraedge.rating.builder;

import java.util.HashSet;
import java.util.Set;

import com.intraedge.rating.dto.AuditInfo;
import com.intraedge.rating.dto.Category;
import com.intraedge.rating.dto.Grade;
import com.intraedge.rating.dto.Skill;
import com.intraedge.rating.dto.Weightage;
import com.intraedge.rating.entity.AuditEntity;
import com.intraedge.rating.entity.CategoryEntity;
import com.intraedge.rating.entity.GradeEntity;
import com.intraedge.rating.entity.SkillEntity;
import com.intraedge.rating.entity.WeightageEntity;

public class DtoBuilder {
	public static Object build(Object object){
		if(object instanceof SkillEntity){
			SkillEntity entity = (SkillEntity)object;
			Skill skill = new Skill();
			skill.setId(entity.getId());
			skill.setName(entity.getName());
			skill.setDescription(entity.getDescription());
			//category
			CategoryEntity categoryEntity = entity.getCategoryEntity();
			if(categoryEntity != null){
				Category category = new Category();
				category.setId(categoryEntity.getId());
				category.setName(categoryEntity.getName());
				category.setDescription(categoryEntity.getDescription());
				category.setAuditInfo(getAuditInfo(categoryEntity.getAuditEntity()));
				skill.setCategory(category);
			}
			skill.setAuditInfo(getAuditInfo(entity.getAuditEntity()));
			return skill;
		}
		if(object instanceof CategoryEntity){
			CategoryEntity entity = (CategoryEntity)object;
			Category category = new Category();
			category.setId(entity.getId());
			category.setName(entity.getName());
			category.setDescription(entity.getDescription());
			//skills
			Set<SkillEntity> skillEntities = entity.getSkills();
			Set<Skill> skills = new HashSet<Skill>();
			for(SkillEntity skillEntity: skillEntities){
				Skill skill = new Skill();
				skill.setId(skillEntity.getId());
				skill.setName(skillEntity.getName());
				skill.setDescription(skillEntity.getDescription());
				skill.setAuditInfo(getAuditInfo(skillEntity.getAuditEntity()));
				skills.add(skill);
			}
			category.setSkills(skills);
			category.setAuditInfo(getAuditInfo(entity.getAuditEntity()));
			return category;
		}
		if(object instanceof GradeEntity){
			GradeEntity entity = (GradeEntity)object;
			Grade grade = new Grade();
			grade.setId(entity.getId());
			grade.setName(entity.getName());
			grade.setDescription(entity.getDescription());
			grade.setValue(entity.getValue());
			grade.setAuditInfo(getAuditInfo(entity.getAuditEntity()));
			return grade;
		}
		if(object instanceof WeightageEntity){
			WeightageEntity entity = (WeightageEntity)object;
			Weightage weightage = new Weightage();
			weightage.setId(entity.getId());
			weightage.setName(entity.getName());
			weightage.setDescription(entity.getDescription());
			weightage.setValue(entity.getValue());
			weightage.setAuditInfo(getAuditInfo(entity.getAuditEntity()));
			return weightage;
		}
		return null;
	}
	
	private static AuditInfo getAuditInfo(AuditEntity auditEntity){
		if(auditEntity != null){
			AuditInfo auditInfo = new AuditInfo();
			auditInfo.setCreatedBy(auditEntity.getCreatedBy());
			auditInfo.setUpdatedBy(auditEntity.getUpdatedBy());
			auditInfo.setCreatedDate(auditEntity.getCreatedDate());
			auditInfo.setUpdatedDate(auditEntity.getUpdatedDate());
			return auditInfo;
		}
		return null;
	}
}