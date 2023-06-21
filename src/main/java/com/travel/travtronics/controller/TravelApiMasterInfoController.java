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

import com.travel.travtronics.model.TravelApiMasterInfo;

@RestController
public class TravelApiMasterInfoController {

	@Autowired
	com.travel.travtronics.repository.TravelApiMasterInfoRepository TravelApiMasterInfoRepository;

	@RequestMapping(value = "/import-excelData-Temp-Tasktable", method = RequestMethod.POST)
	public ResponseEntity<List<TravelApiMasterInfo>> importExcel(@RequestParam("file") MultipartFile files)
			throws IOException {
		HttpStatus status = HttpStatus.OK;
		List<TravelApiMasterInfo> info = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {
				TravelApiMasterInfo masterInfo = new TravelApiMasterInfo();
				XSSFRow row = worksheet.getRow(index);
				DataFormatter formatter = new DataFormatter();
//				if (row.getCell(0) != null) {
//					String sno = formatter.formatCellValue(row.getCell(0));
//					masterInfo.setSno(Long.parseLong(sno));
//				}
				if (row.getCell(0) != null) {
					String application = formatter.formatCellValue(row.getCell(0));
					if (application.isBlank()) {
						masterInfo.setApplication(" ");
					} else {
						masterInfo.setApplication(application);
					}
				} else {
					masterInfo.setApplication(" ");
				}
				if (row.getCell(1) != null) {
					String form = formatter.formatCellValue(row.getCell(1));
					if (form.isBlank()) {
						masterInfo.setForm(" ");
					} else {
						masterInfo.setForm(form);
					}
				} else {
					masterInfo.setForm(" ");
				}
				if (row.getCell(2) != null) {
					String action = formatter.formatCellValue(row.getCell(2));
					if (action.isBlank()) {
						masterInfo.setAction(" ");
					} else {
						masterInfo.setAction(action);
					}
				} else {
					masterInfo.setAction(" ");
				}
				if (row.getCell(3) != null) {
					String url = formatter.formatCellValue(row.getCell(3));
					if (url.isBlank()) {
						masterInfo.setUrl(" ");
					} else {
						masterInfo.setUrl(url);
					}
				} else {
					masterInfo.setUrl(" ");
				}
				if (row.getCell(4) != null) {
					String purpose = formatter.formatCellValue(row.getCell(4));
					if (purpose.isBlank()) {
						masterInfo.setPurpose(" ");
					} else {
						masterInfo.setPurpose(purpose);
					}
				} else {
					masterInfo.setPurpose(" ");
				}
				if (row.getCell(5) != null) {
					String programmer = formatter.formatCellValue(row.getCell(5));
					if (programmer.isBlank()) {
						masterInfo.setProgrammer(" ");
					} else {
						masterInfo.setProgrammer(programmer);
					}
				} else {
					masterInfo.setProgrammer(" ");
				}
				if (row.getCell(6) != null) {
					String author = formatter.formatCellValue(row.getCell(6));
					if (author.isBlank()) {
						masterInfo.setAuthor(" ");
					} else {
						masterInfo.setAuthor(author);
					}
				} else {
					masterInfo.setAuthor(" ");
				}
				if (row.getCell(7) != null) {
					String technology = formatter.formatCellValue(row.getCell(7));
					if (technology.isBlank()) {
						masterInfo.setTechnology(" ");
					} else {
						masterInfo.setTechnology(technology);
					}
				} else {
					masterInfo.setTechnology(" ");
				}
				if (row.getCell(8) != null) {
					String controllerName = formatter.formatCellValue(row.getCell(8));
					if (controllerName.isBlank()) {
						masterInfo.setControllerName(" ");
					} else {
						masterInfo.setControllerName(controllerName);
					}
				} else {
					masterInfo.setControllerName(" ");
				}
				if (row.getCell(9) != null) {
					String project = formatter.formatCellValue(row.getCell(9));
					if (project.isBlank()) {
						masterInfo.setProject(" ");
					} else {
						masterInfo.setProject(project);
					}
				} else {
					masterInfo.setProject(" ");
				}
				if (row.getCell(10) != null) {
					String image = formatter.formatCellValue(row.getCell(10));
					if (image.isBlank()) {
						masterInfo.setImage(" ");
					} else {
						masterInfo.setImage(image);
					}
				} else {
					masterInfo.setImage(" ");
				}
				if (row.getCell(11) != null) {
					String server = formatter.formatCellValue(row.getCell(11));
					if (server.isBlank()) {
						masterInfo.setServer(" ");
					} else {
						masterInfo.setServer(server);
					}
				} else {
					masterInfo.setServer(" ");
				}
//				if(row.getCell(13)!=null) {
//					String date =formatter.formatCellValue(row.getCell(13));
//					if(date.isBlank()) {
//						masterInfo.setDate("N/A");
//					}else {
//						masterInfo.setDate(date);
//					}
//				}else {
//					masterInfo.setDate(" ");
//				}
				TravelApiMasterInfoRepository.save(masterInfo);
				info.add(masterInfo);
			}

		}

		return new ResponseEntity<>(info, status);
	}
}
