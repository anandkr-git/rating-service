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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author akumar1
 *
 */
@Entity
@Table(name = "INTERVIEW")
public class InterviewEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
  private Long id;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 200)
	private String name;
	
	@Column(name = "SCORE")
	private Double score;
	
	@Column(name = "PRIVATE_COMMENT", length = 200)
	private String privateComment;
	
	@Column(name = "PUBLIC_COMMENT", length = 200)
	private String publicComment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="job_profile_id")
	private JobProfileEntity jobProfileEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserEntity userEntity;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) 
	@JoinColumn(name="interview_id")
	private Set<InterviewDetailsEntity> interviewDetails = new HashSet<InterviewDetailsEntity>();
	
	@Embedded
	private AuditEntity auditEntity;
	
	public InterviewEntity(){
		
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
	public String getPrivateComment() {
		return privateComment;
	}

	public void setPrivateComment(String privateComment) {
		this.privateComment = privateComment;
	}

	public String getPublicComment() {
		return publicComment;
	}

	public void setPublicComment(String publicComment) {
		this.publicComment = publicComment;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public JobProfileEntity getJobProfileEntity() {
		return jobProfileEntity;
	}

	public void setJobProfileEntity(JobProfileEntity jobProfileEntity) {
		this.jobProfileEntity = jobProfileEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Set<InterviewDetailsEntity> getInterviewDetails() {
		return interviewDetails;
	}

	public void setInterviewDetails(Set<InterviewDetailsEntity> interviewDetails) {
		this.interviewDetails = interviewDetails;
	}

	public AuditEntity getAuditEntity() {
		return auditEntity;
	}
	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}
	
}
