/**
 * 
 */
package com.intraedge.rating.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author akumar1
 *
 */
@Entity
@Table(name = "JOB_PROFILE_DETAILS")
public class JobProfileDetailsEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
  private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="job_profile_id")
	private JobProfileEntity jobProfileEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="skill_id")
	private SkillEntity skillEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="weightage_id")
	private WeightageEntity weightageEntity;
	
	@Embedded
	private AuditEntity auditEntity;
	
	public JobProfileDetailsEntity(){
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public JobProfileEntity getJobProfileEntity() {
		return jobProfileEntity;
	}

	public void setJobProfileEntity(JobProfileEntity jobProfileEntity) {
		this.jobProfileEntity = jobProfileEntity;
	}

	public SkillEntity getSkillEntity() {
		return skillEntity;
	}

	public void setSkillEntity(SkillEntity skillEntity) {
		this.skillEntity = skillEntity;
	}

	public WeightageEntity getWeightageEntity() {
		return weightageEntity;
	}

	public void setWeightageEntity(WeightageEntity weightageEntity) {
		this.weightageEntity = weightageEntity;
	}

	public AuditEntity getAuditEntity() {
		return auditEntity;
	}
	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}
	
}
