package com.travel.travtronics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="documents")
public class DMSModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long docId;
	private String entityType;
	private String entityId;
	private String entityName;
	
	public DMSModel(String entityType, String entityId, String entityName) {
		super();
		this.entityType = entityType;
		this.entityId = entityId;
		this.entityName = entityName;
	}
	
	public DMSModel() {
		super();
	}

	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
