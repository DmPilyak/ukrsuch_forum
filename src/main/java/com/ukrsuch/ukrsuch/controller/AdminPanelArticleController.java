package com.ukrsuch.ukrsuch.controller;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.ukrsuch.ukrsuch.model.ArticleModel;
import com.ukrsuch.ukrsuch.service.ArticleService;

@Controller
@MultipartConfig(maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024 * 1024 * 1024)
public class AdminPanelArticleController {
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/admin_panel_7355608_articles")
	public String adminArticles(Model model, HttpServletRequest request, HttpServletResponse response) {

		return "adminPanel";
	}

	@RequestMapping(value = "/admin_panel_7355608_articles", method = RequestMethod.POST)
	public String adminAddArticles(@RequestParam("file") MultipartFile img, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String autorName = request.getParameter("autorName");
		Blob blobImg = articleService.getBlobFromMultipartFile(img);
		
		ArticleModel article = new ArticleModel();
		article.setTitle(title);
		article.setDescription(description);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		article.setDate(formatter.format(date));
		article.setAutorName(autorName);
		article.setImg(blobImg);
		articleService.addArticleADMIN(article);

		return "adminPanel";
	}
}
