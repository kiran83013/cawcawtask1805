package com.travel.travtronics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "company_segment_activity_license")
@Entity
public class CompanySegmentLicense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SNO")
	private Long sno;
	
	@Column(name = "EnergyClubMemership", columnDefinition = "TEXT")
	private String energyClubMemership; 
	
	@Column(name = "DDEMembershiprequired", columnDefinition = "TEXT")
	private String dDEMembershipRequired;
	
	@Column(name = "BusinessSector", columnDefinition = "TEXT")
	private String businessSector;
	
	@Column(name = "SubSector", columnDefinition = "TEXT")
	private String subSector;
	
	@Column(name = "ActivityCode", columnDefinition = "TEXT")
	private String activityCode;
	
	@Column(name = "ActivityName", columnDefinition = "TEXT")
	private String activityName;
	
	@Column(name = "ActivityNameArabic", columnDefinition = "TEXT")
	private String activityNameArabic;
	
	@Column(name = "LicenseType", columnDefinition = "TEXT")
	private String licenseType;
	
	@Column(name = "ActivityDescription", columnDefinition = "TEXT")
	private String activityDescription;
	
	@Column(name = "PropertyType", columnDefinition = "TEXT")
	private String propertyType;
	
	@Column(name = "Restrictions", columnDefinition = "TEXT")
	private String restrictions;
	
	@Column(name = "AdditionalDMCCRequirements", columnDefinition = "TEXT")
	private String additionalDMCCRequirements;
	
	@Column(name = "MinimumShareCapital", columnDefinition = "TEXT")
	private String minimumShareCapital;
	
	@Column(name = "ThirdPartyNoObjectionCertificateNOCs", columnDefinition = "TEXT")
	private String thirdPartyNoObjectionCertificates;

	public Long getSno() {
		return sno;
	}

	public void setSno(Long sno) {
		this.sno = sno;
	}

	public String getEnergyClubMemership() {
		return energyClubMemership;
	}

	public void setEnergyClubMemership(String energyClubMemership) {
		this.energyClubMemership = energyClubMemership;
	}

	public String getdDEMembershipRequired() {
		return dDEMembershipRequired;
	}

	public void setdDEMembershipRequired(String dDEMembershipRequired) {
		this.dDEMembershipRequired = dDEMembershipRequired;
	}

	public String getBusinessSector() {
		return businessSector;
	}

	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}

	public String getSubSector() {
		return subSector;
	}

	public void setSubSector(String subSector) {
		this.subSector = subSector;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityNameArabic() {
		return activityNameArabic;
	}

	public void setActivityNameArabic(String activityNameArabic) {
		this.activityNameArabic = activityNameArabic;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	public String getAdditionalDMCCRequirements() {
		return additionalDMCCRequirements;
	}

	public void setAdditionalDMCCRequirements(String additionalDMCCRequirements) {
		this.additionalDMCCRequirements = additionalDMCCRequirements;
	}

	public String getMinimumShareCapital() {
		return minimumShareCapital;
	}

	public void setMinimumShareCapital(String minimumShareCapital) {
		this.minimumShareCapital = minimumShareCapital;
	}

	public String getThirdPartyNoObjectionCertificates() {
		return thirdPartyNoObjectionCertificates;
	}

	public void setThirdPartyNoObjectionCertificates(String thirdPartyNoObjectionCertificates) {
		this.thirdPartyNoObjectionCertificates = thirdPartyNoObjectionCertificates;
	}	
}
