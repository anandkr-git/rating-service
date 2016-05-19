package com.intraedge.rating.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "jobprofiledeatils")
@XmlType(propOrder = { "id", "jobProfile", "skill", "weightage", "auditInfo" })
@XmlAccessorType(XmlAccessType.FIELD)
public class JobProfileDetails {

	private Long id;
	@XmlElement (name = "jobProfile")
	private JobProfile jobProfile;
	@XmlElement (name = "skill")
	private Skill skill;
	@XmlElement (name = "weightage")
	private Weightage weightage;
	@XmlElement (name = "auditInfo")
	private AuditInfo auditInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public JobProfile getJobProfile() {
		return jobProfile;
	}
	public void setJobProfile(JobProfile jobProfile) {
		this.jobProfile = jobProfile;
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
	public AuditInfo getAuditInfo() {
		return auditInfo;
	}
	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
}
