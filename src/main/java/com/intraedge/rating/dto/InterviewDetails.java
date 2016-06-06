package com.intraedge.rating.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.intraedge.rating.dto.AuditInfo;
import com.intraedge.rating.dto.Grade;
import com.intraedge.rating.dto.Interview;
import com.intraedge.rating.dto.Skill;
import com.intraedge.rating.dto.Weightage;

@XmlRootElement(name = "interviewDetails")
@XmlType(propOrder = { "id", "interview", "skill", "weightage", "grade", "audit" })
@XmlAccessorType(XmlAccessType.FIELD)
public class InterviewDetails {
	
		private Long id;
		
		@XmlElement (name = "interview")
		private Interview  interview ;
		
		@XmlElement (name = "skill")
		private Skill  skill ;
		
		@XmlElement (name = "weightage")
		private Weightage  weightage ;
		
		@XmlElement (name = "grade")
		private Grade  grade ;
		
		@XmlElement (name = "auditInfo")
		private AuditInfo  audit ;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Interview getInterview() {
			return interview;
		}
		public void setInterview(Interview interview) {
			this.interview = interview;
		}
		public Skill getSkill() {
			return skill;
		}
		public void setSkill(Skill skill) {
			this.skill = skill;
		}
		public Weightage getWeightage() {
			return weightage;
		}
		public void setWeightage(Weightage weightage) {
			this.weightage = weightage;
		}
		public Grade getGrade() {
			return grade;
		}
		public void setGrade(Grade grade) {
			this.grade = grade;
		}
		public AuditInfo getAudit() {
			return audit;
		}
		public void setAudit(AuditInfo audit) {
			this.audit = audit;
		}


}
