package com.intraedge.rating.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "jobprofile")
@XmlType(propOrder = { "id", "name", "description", "jobProfileDetails", "auditInfo" })
@XmlAccessorType(XmlAccessType.FIELD)
public class JobProfile {

	private Long id;
	private String name;
	private String description;
	
	@XmlElementWrapper(name="jobProfileDetails")
	@XmlElement (name = "jobProfileDetail")
	private Set<JobProfileDetails> jobProfileDetails = new HashSet<JobProfileDetails>();
	
	@XmlElement (name = "auditInfo")
	private AuditInfo auditInfo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<JobProfileDetails> getJobProfileDetails() {
		return jobProfileDetails;
	}
	public void setJobProfileDetails(Set<JobProfileDetails> jobProfileDetails) {
		this.jobProfileDetails = jobProfileDetails;
	}
	public AuditInfo getAuditInfo() {
		return auditInfo;
	}
	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}	
}
