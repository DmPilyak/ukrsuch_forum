package com.ukrsuch.ukrsuch.controller;

import java.sql.Blob;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ukrsuch.ukrsuch.model.ComicsArticleModel;
import com.ukrsuch.ukrsuch.service.ComicsService;

@Controller
@MultipartConfig(maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024 * 1024 * 1024)
public class AdmitPanelComicsController {
	
	@Autowired
	private ComicsService comicsService;

	@RequestMapping(value = "/admin_panel_7355608_comics")
	public String adminComics(Model model, HttpServletRequest request, HttpServletResponse response) {
		return "comicsAdminPanel";
	}

	@RequestMapping(value = "/admin_panel_7355608_comics", method = RequestMethod.POST)
	public String adminAddComics(@RequestParam("file") MultipartFile img, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String autorName = request.getParameter("autorName");
		Blob blobImg = comicsService.getBlobFromMultipartFile(img);
		
		ComicsArticleModel comics = new ComicsArticleModel();
		comics.setTitle(title);
		comics.setDescription(description);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		comics.setDate(formatter.format(date));
		comics.setAutorName(autorName);
		comics.setImg(blobImg);
		comicsService.addComicsADMIN(comics);

		return "comicsAdminPanel";
	}
	
}
