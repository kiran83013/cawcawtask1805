package com.travel.travtronics.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	private final Path UPLOAD_DIR = Paths.get("uploads");

	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				throw new RuntimeException("Invalid file path");
			}

			if (!Files.exists(UPLOAD_DIR)) {
				Files.createDirectories(UPLOAD_DIR);
			}

			Path filePath = UPLOAD_DIR.resolve(fileName);
			Files.write(filePath, file.getBytes());

			model.addAttribute("message", "File uploaded successfully!");
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("message", "Failed to upload file");
		}
		return "upload";
	}

	@GetMapping("/images/**")
	public void getImage(@RequestParam("path") String path, HttpServletResponse response) throws IOException {
		String imagePath = "classpath:" + path;
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		Resource resource = resourceLoader.getResource(imagePath);
		InputStream inputStream = resource.getInputStream();
		IOUtils.copy(inputStream, response.getOutputStream());
	}
}
