package com.intraedge.rating.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private Long id;
	
	@Column(name="NAME", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name="DESCRIPTION", nullable = true, length = 200)
	private String description;
	
	@Embedded
	private AuditEntity auditEntity;
	
	public RoleEntity(){
		
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
	
	public AuditEntity getAuditEntity() {
		return auditEntity;
	}
	public void setAuditEntity(AuditEntity auditEntity) {
		this.auditEntity = auditEntity;
	}
}
