package com.intraedge.rating.builder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.intraedge.rating.dto.AuditInfo;
import com.intraedge.rating.dto.Category;
import com.intraedge.rating.dto.Grade;
import com.intraedge.rating.dto.Interview;
import com.intraedge.rating.dto.InterviewDetails;
import com.intraedge.rating.dto.JobProfile;
import com.intraedge.rating.dto.JobProfileDetails;
import com.intraedge.rating.dto.Role;
import com.intraedge.rating.dto.Skill;
import com.intraedge.rating.dto.Weightage;
import com.intraedge.rating.entity.AuditEntity;
import com.intraedge.rating.entity.CategoryEntity;
import com.intraedge.rating.entity.GradeEntity;
import com.intraedge.rating.entity.InterviewDetailsEntity;
import com.intraedge.rating.entity.InterviewEntity;
import com.intraedge.rating.entity.JobProfileDetailsEntity;
import com.intraedge.rating.entity.JobProfileEntity;
import com.intraedge.rating.entity.RoleEntity;
import com.intraedge.rating.entity.SkillEntity;
import com.intraedge.rating.entity.UserEntity;
import com.intraedge.rating.entity.WeightageEntity;

public class EntityBuilder {
	public static Object build(Object object){
		if(object instanceof Skill){
			Skill skill = (Skill)object;
			SkillEntity skillEntity = new SkillEntity();
			skillEntity.setId(skill.getId());
			skillEntity.setName(skill.getName());
			skillEntity.setDescription(skill.getDescription());
			if(skill.getCategory() != null){
				CategoryEntity categoryEntity = new CategoryEntity();
				categoryEntity.setId(skill.getCategory().getId());
				categoryEntity.setName(skill.getCategory().getName());
				categoryEntity.setDescription(skill.getCategory().getDescription());
				categoryEntity.setAuditEntity(buildAuditEntity(skill.getCategory().getAuditInfo()));
				skillEntity.setCategoryEntity(categoryEntity);
			}
			skillEntity.setAuditEntity(buildAuditEntity(skill.getAuditInfo()));
			return skillEntity;
		}
		if(object instanceof Category){
			Category category = (Category)object;
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity.setId(category.getId());
			categoryEntity.setName(category.getName());
			categoryEntity.setDescription(category.getDescription());
			Set<Skill> skills = category.getSkills();
			Set<SkillEntity> skillEntities = new HashSet<SkillEntity>();
			for(Skill skill: skills){
				SkillEntity skillEntity = new SkillEntity();
				skillEntity.setId(skill.getId());
				skillEntity.setName(skill.getName());
				skillEntity.setDescription(skill.getDescription());
				skillEntity.setAuditEntity(buildAuditEntity(skill.getAuditInfo()));
				skillEntities.add(skillEntity);
			}
			categoryEntity.setSkills(skillEntities);
			categoryEntity.setAuditEntity(buildAuditEntity(category.getAuditInfo()));
			return categoryEntity;
		}
		if(object instanceof Grade){
			Grade grade = (Grade)object;
			GradeEntity gradeEntity = new GradeEntity();
			gradeEntity.setId(grade.getId());
			gradeEntity.setName(grade.getName());
			gradeEntity.setDescription(grade.getDescription());
			gradeEntity.setValue(grade.getValue());
			gradeEntity.setAuditEntity(buildAuditEntity(grade.getAuditInfo()));
			return gradeEntity;
		}
		if(object instanceof Role){
			Role role = (Role)object;
			RoleEntity roleEntity = new RoleEntity();
			roleEntity.setId(role.getId());
			roleEntity.setName(role.getName());
			roleEntity.setDescription(role.getDescription());
			roleEntity.setAuditEntity(buildAuditEntity(role.getAuditInfo()));
			return roleEntity;
		}
		if(object instanceof Weightage){
			Weightage grade = (Weightage)object;
			WeightageEntity weightageEntity = new WeightageEntity();
			weightageEntity.setId(grade.getId());
			weightageEntity.setName(grade.getName());
			weightageEntity.setDescription(grade.getDescription());
			weightageEntity.setValue(grade.getValue());
			weightageEntity.setAuditEntity(buildAuditEntity(grade.getAuditInfo()));
			return weightageEntity;
		}
		if(object instanceof Interview)
		{
			System.out.println("\n \n building interview entity");
			InterviewEntity interviewEntity=new InterviewEntity();
			Interview interview = (Interview)object;
			interviewEntity.setId(interview.getId());
			interviewEntity.setName(interview.getName());
			interviewEntity.setPrivateComment(interview.getPrivateComment());
			interviewEntity.setPublicComment(interview.getPublicComment());
			interviewEntity.setScore(interview.getScore());
			interviewEntity.setAuditEntity(buildAuditEntity(interview.getAudit()));
			interviewEntity.setInterviewer((UserEntity) build(interview.getInterviewer()));
			interviewEntity.setInterviewee((UserEntity) build(interview.getInterviewee()));
			interviewEntity.setJobProfileEntity((JobProfileEntity)build(interview.getJobProfile()));
			
			
			Set<InterviewDetailsEntity> interviewDetailsEntity=new HashSet<>();
			Set<InterviewDetails> interviewDetails = interview.getInterviewDetails();
			
			for(InterviewDetails interviewDetail:interviewDetails)
			{
				System.out.println("building interview details"); 
				InterviewDetailsEntity interviewDetailEntity = new InterviewDetailsEntity();
				interviewDetailEntity.setId(interviewDetail.getId());
				interviewDetailEntity.setGradeEntity((GradeEntity) build(interviewDetail.getGrade()));
				interviewDetailEntity.setSkillEntity((SkillEntity) build(interviewDetail.getSkill()));
				interviewDetailEntity.setWeightageEntity((WeightageEntity) build(interviewDetail.getWeightage()));
				interviewDetailEntity.setAuditEntity(buildAuditEntity(interviewDetail.getAudit()));
				
				interviewDetailsEntity.add(interviewDetailEntity);
			}
			
			interviewEntity.setInterviewDetails(interviewDetailsEntity);
			
			return interviewEntity;
		}
		if(object instanceof JobProfile){
			JobProfile jobProfile = (JobProfile)object;
			
			JobProfileEntity jobProfileEntity = new JobProfileEntity();
			jobProfileEntity.setId(jobProfile.getId());
			jobProfileEntity.setName(jobProfile.getName());
			jobProfileEntity.setDescription(jobProfile.getDescription());
			
			Set<JobProfileDetails> jobProfileDetails = jobProfile.getJobProfileDetails();
			Set<JobProfileDetailsEntity> jobProfileDetailsEntities = new HashSet<JobProfileDetailsEntity>();
			
			for(JobProfileDetails jobProfileDetail : jobProfileDetails){
				JobProfileDetailsEntity jobProfileDetailsEntity = new JobProfileDetailsEntity();
				
				jobProfileDetailsEntity.setId(jobProfileDetail.getId());
				jobProfileDetailsEntity.setSkillEntity((SkillEntity)build(jobProfileDetail.getSkill()));
				jobProfileDetailsEntity.setWeightageEntity((WeightageEntity)build(jobProfileDetail.getWeightage()));			
				jobProfileDetailsEntity.setAuditEntity(buildAuditEntity(jobProfileDetail.getAuditInfo()));
				
				jobProfileDetailsEntities.add(jobProfileDetailsEntity);
			}
			jobProfileEntity.setJobProfileDetails(jobProfileDetailsEntities);
			jobProfileEntity.setAuditEntity(buildAuditEntity(jobProfile.getAuditInfo()));
			
			return jobProfileEntity;
		}
		if(object instanceof JobProfileDetails){
			JobProfileDetails jobProfileDetails = (JobProfileDetails)object;
			JobProfileDetailsEntity jobProfileDetailsEntity = new JobProfileDetailsEntity();
			
			jobProfileDetailsEntity.setId(jobProfileDetails.getId());
			jobProfileDetailsEntity.setSkillEntity((SkillEntity)build(jobProfileDetails.getSkill()));
			jobProfileDetailsEntity.setWeightageEntity((WeightageEntity)build(jobProfileDetails.getWeightage()));			
			jobProfileDetailsEntity.setAuditEntity(buildAuditEntity(jobProfileDetails.getAuditInfo()));
			
			return jobProfileDetailsEntity;
		
		}
		return null;
	}
	
	public static AuditEntity buildAuditEntity(AuditInfo auditInfo){
		AuditEntity auditEntity = new AuditEntity();
		if(auditInfo != null){
			auditEntity.setCreatedBy(auditInfo.getCreatedBy());
			auditEntity.setUpdatedBy(auditInfo.getUpdatedBy());
			if(auditInfo.getCreatedDate() == null){
				auditEntity.setCreatedDate(new Date());
			} else{
				auditEntity.setCreatedDate(auditInfo.getCreatedDate());
				auditEntity.setUpdatedDate(new Date());
			}
		} else {
			auditEntity.setCreatedBy("RATING_SERVICES");
			auditEntity.setCreatedDate(new Date());
			auditEntity.setUpdatedBy("RATING_SERVICES");
		}
		return auditEntity;
	}
}
