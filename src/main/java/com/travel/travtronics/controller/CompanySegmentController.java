package com.travel.travtronics.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travel.travtronics.model.CompanySegmentLicense;
import com.travel.travtronics.repository.CompanySegmentLicenseRepository;

@RestController
public class CompanySegmentController {

	

	@Autowired
	CompanySegmentLicenseRepository companySegmentLicenseRepository;

	@RequestMapping(value = "/import-excelData-Temp-Task", method = RequestMethod.POST)
	public ResponseEntity<List<CompanySegmentLicense>> importExcelTempFile(@RequestParam("file") MultipartFile files)
			throws IOException {
		HttpStatus status = HttpStatus.OK;
		List<CompanySegmentLicense> productList = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
		    if (index > 0) {
		      CompanySegmentLicense product = new CompanySegmentLicense();
		      XSSFRow row = worksheet.getRow(index);
		      DataFormatter formatter = new DataFormatter();
				if (row.getCell(0) != null) {
					String sno = formatter.formatCellValue(row.getCell(0));
					product.setSno(Long.parseLong(sno));
				}

				if (row.getCell(1) != null) {
					String energyClubMemership = formatter.formatCellValue(row.getCell(1));
					if (energyClubMemership.isBlank()) {
						product.setEnergyClubMemership("N/A");
					} else {
						product.setEnergyClubMemership(energyClubMemership);
					}
				} else {
					product.setEnergyClubMemership(" ");
				}

				if (row.getCell(2) != null) {
					String dDEMembershipRequired = formatter.formatCellValue(row.getCell(2));
					if (dDEMembershipRequired.isBlank()) {
						product.setdDEMembershipRequired("N/A");
					} else {
						product.setdDEMembershipRequired(dDEMembershipRequired);
					}
				} else {
					product.setdDEMembershipRequired(" ");
				}
				if (row.getCell(3) != null) {
					String businessSector = formatter.formatCellValue(row.getCell(3));
					if (businessSector.isBlank()) {
						product.setBusinessSector("N/A");
					} else {
						product.setBusinessSector(businessSector);
					}
				} else {
					product.setBusinessSector(" ");
				}
				if (row.getCell(4) != null) {
					String subSector = formatter.formatCellValue(row.getCell(4));
					if (subSector.isBlank()) {
						product.setSubSector("N/A");
					} else {
						product.setSubSector(subSector);
					}
				} else {
					product.setSubSector(" ");
				}
				if (row.getCell(5) != null) {
					String activityCode = formatter.formatCellValue(row.getCell(5));
					if (activityCode.isBlank()) {
						product.setActivityCode("N/A");
					} else {
						product.setActivityCode(activityCode);
					}
				} else {
					product.setActivityCode(" ");
				}
				if (row.getCell(6) != null) {
					String activityName = formatter.formatCellValue(row.getCell(6));
					if (activityName.isBlank()) {
						product.setActivityName("N/A");
					} else {
						product.setActivityName(activityName);
					}
				} else {
					product.setActivityName(" ");
				}

				if (row.getCell(7) != null) {
					String activityNameArabic = formatter.formatCellValue(row.getCell(7));
					if (activityNameArabic.isBlank()) {
						product.setActivityNameArabic("N/A");
					} else {
						product.setActivityNameArabic(activityNameArabic);
					}
				} else {
					product.setActivityNameArabic(" ");
				}
				if (row.getCell(8) != null) {
					String licenseType = formatter.formatCellValue(row.getCell(8));
					if (licenseType.isBlank()) {
						product.setLicenseType("N/A");
					} else {
						product.setLicenseType(licenseType);
					}
				} else {
					product.setLicenseType(" ");
				}
				if (row.getCell(9) != null) {
					String activityDescription = formatter.formatCellValue(row.getCell(9));
					if (activityDescription.isBlank()) {
						product.setActivityDescription("N/A");
					} else {
						product.setActivityDescription(activityDescription);
					}
				} else {
					product.setActivityDescription(" ");
				}
				if (row.getCell(10) != null) {
					String propertyType = formatter.formatCellValue(row.getCell(10));
					if (propertyType.isBlank()) {
						product.setPropertyType("N/A");
					} else {
						product.setPropertyType(propertyType);
					}
				} else {
					product.setPropertyType(" ");
				}
				if (row.getCell(11) != null) {
					String restrictions = formatter.formatCellValue(row.getCell(11));
					if (restrictions.isBlank()) {
						product.setRestrictions("N/A");
					} else {
						product.setRestrictions(restrictions);
					}
				} else {
					product.setRestrictions(" ");
				}

				if (row.getCell(12) != null) {
					String additionalDMCCRequirements = formatter.formatCellValue(row.getCell(12));
					if (additionalDMCCRequirements.isBlank()) {
						product.setAdditionalDMCCRequirements("N/A");
					} else {
						product.setAdditionalDMCCRequirements(additionalDMCCRequirements);
					}
				} else {
					product.setAdditionalDMCCRequirements(" ");
				}

				if (row.getCell(13) != null) {
					String minimumShareCapital = formatter.formatCellValue(row.getCell(13));
					if (minimumShareCapital.isBlank()) {
						product.setMinimumShareCapital("N/A");
					} else {
						product.setMinimumShareCapital(minimumShareCapital);
					}
				} else {
					product.setMinimumShareCapital(" ");
				}
				if (row.getCell(14) != null) {
					String thirdPartyNoObjectionCertificates = formatter.formatCellValue(row.getCell(14));
					if (thirdPartyNoObjectionCertificates.isBlank()) {
						product.setThirdPartyNoObjectionCertificates("N/A");
					} else {
						product.setThirdPartyNoObjectionCertificates(thirdPartyNoObjectionCertificates);
					}
				} else {
					product.setThirdPartyNoObjectionCertificates(" ");
				}

				companySegmentLicenseRepository.save(product);
				productList.add(product);
			}
		}
		return new ResponseEntity<>(productList, status);
	}
}
