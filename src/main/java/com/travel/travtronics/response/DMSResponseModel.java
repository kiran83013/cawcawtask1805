package com.travel.travtronics.response;

public class DMSResponseModel {
	
	private String entityName;
	private String entityCdnUrl;
	
	public DMSResponseModel(String entityName, String entityCdnUrl) {
		super();
		this.entityName = entityName;
		this.entityCdnUrl = entityCdnUrl;
	}
	
	public DMSResponseModel() {
		super();
	}

	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityCdnUrl() {
		return entityCdnUrl;
	}
	public void setEntityCdnUrl(String entityCdnUrl) {
		this.entityCdnUrl = entityCdnUrl;
	}

}
