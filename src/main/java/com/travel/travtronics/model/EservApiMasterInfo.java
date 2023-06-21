package com.travel.travtronics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eserv_api_master_info")
public class EservApiMasterInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SNO")
	private Long sno;

	@Column(name = "APP", columnDefinition = "LONGTEXT")
	private String application;

	@Column(name = "FORM", columnDefinition = "LONGTEXT")
	private String form;

	@Column(name = "ACTIONS", columnDefinition = "LONGTEXT")
	private String action;

	@Column(name = "URL", columnDefinition = "LONGTEXT")
	private String url;

	@Column(name = "PURPOSE", columnDefinition = "LONGTEXT")
	private String purpose;

	@Column(name = "PROGRAMMER", columnDefinition = "LONGTEXT")
	private String programmer;

	@Column(name = "AUTHOR", columnDefinition = "LONGTEXT")
	private String author;

	@Column(name = "TECHNOLOGY", columnDefinition = "LONGTEXT")
	private String technology;

	@Column(name = "CONTROLLERNAME", columnDefinition = "LONGTEXT")
	private String controllerName;

	@Column(name = "PROJECT", columnDefinition = "LONGTEXT")
	private String project;

	@Column(name = "IMAGE", columnDefinition = "LONGTEXT")
	private String image;

	@Column(name = "SERVERIP", columnDefinition = "LONGTEXT")
	private String server;

	public Long getSno() {
		return sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getProgrammer() {
		return programmer;
	}

	public void setProgrammer(String programmer) {
		this.programmer = programmer;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
}
