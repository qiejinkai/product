package com.qjk.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
public class FileController {

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam("files") MultipartFile[] files,
			HttpServletRequest request) throws IOException {

		if (files != null) {

			for (MultipartFile file : files) {
				
				if(!file.isEmpty()){
				String path = request.getSession().getServletContext()
						.getRealPath("/file");
				System.out.println(path);
				File f = new File(path + "/" + file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), f);

				System.out.println(file.getName() + " , "
						+ file.getContentType() + " , " + file.getSize());
				}

			}
		}

		return "file/upload";
	}

}
