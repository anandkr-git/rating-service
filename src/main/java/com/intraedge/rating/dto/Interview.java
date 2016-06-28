package com.intraedge.rating.dto;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.intraedge.rating.dto.AuditInfo;
import com.intraedge.rating.dto.InterviewDetails;
import com.intraedge.rating.dto.JobProfile;
import com.intraedge.rating.dto.User;

@XmlRootElement(name = "interview")
@XmlType(propOrder = { "id", "name", "score", "privateComment", "publicComment", "jobProfile", "interviewer", "interviewee", "interviewDetails", "audit" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Interview {
	
		private Long id;
		private String name;
		private Double score;		
		private String privateComment;

		private String publicComment;

		@XmlElement (name = "jobProfile")
		private JobProfile jobProfile;

		@XmlElement (name = "interviewer")
		private User interviewer;
		
		@XmlElement (name = "interviewee")
		private User interviewee;

		@XmlElementWrapper(name="interviewDetails")
		@XmlElement(name="interviewDetail")
		private Set<InterviewDetails> interviewDetails = new HashSet<InterviewDetails>();	
		
		@XmlElement (name = "auditInfo")
		private AuditInfo audit;

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

		public Double getScore() {
			return score;
		}

		public void setScore(Double score) {
			this.score = score;
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

		public JobProfile getJobProfile() {
			return jobProfile;
		}

		public void setJobProfile(JobProfile jobProfile) {
			this.jobProfile = jobProfile;
		}

		public User getInterviewer() {
			return interviewer;
		}

		public void setInterviewer(User interviewer) {
			this.interviewer = interviewer;
		}

		public User getInterviewee() {
			return interviewee;
		}

		public void setInterviewee(User interviewee) {
			this.interviewee = interviewee;
		}

		public Set<InterviewDetails> getInterviewDetails() {
			return interviewDetails;
		}

		public void setInterviewDetails(Set<InterviewDetails> interviewDetails) {
			this.interviewDetails = interviewDetails;
		}

		public AuditInfo getAudit() {
			return audit;
		}

		public void setAudit(AuditInfo audit) {
			this.audit = audit;
		}



}
