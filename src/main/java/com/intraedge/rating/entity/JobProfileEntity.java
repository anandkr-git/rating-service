/**
 * 
 */
package com.intraedge.rating.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author akumar1
 *
 */
@Entity
@Table(name = "JOB_PROFILE")
public class JobProfileEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
  private Long id;
	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	private String name;
	@Column(name = "DESCRIPTION", length = 200)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) 
	@JoinColumn(name="job_profile_id")
	private Set<JobProfileDetailsEntity> jobProfileDetails = new HashSet<JobProfileDetailsEntity>();
	
	@Embedded
	private AuditEntity auditEntity;
	
	public JobProfileEntity(){
		
	}

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

	public Set<JobProfileDetailsEntity> getJobProfileDetails() {
		return jobProfileDetails;
	}

	public void setJobProfileDetails(Set<JobProfileDetailsEntity> jobProfileDetails) {
		this.jobProfileDetails = jobProfileDetails;
	}

	public AuditEntity getAuditEntity() {
		return auditEntity;
	}
	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}
	
}
