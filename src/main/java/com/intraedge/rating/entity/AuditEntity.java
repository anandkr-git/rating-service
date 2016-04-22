package com.intraedge.rating.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
@Table(name="AUDIT")
@Embeddable
public class AuditEntity {

	@Column(name="CREATED_BY",nullable=false)
	private String createdBy;
	
	@Column(name="UPDATED_BY",nullable=true)
	private String updatedBy;
	
	@Column(name="CREATED_DATE",nullable=false)
	private Date createdDate;
	
	@Column(name="UPDATED_DATE",nullable=true)
	private Date updatedDate;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
