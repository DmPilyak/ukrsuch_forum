package com.ukrsuch.ukrsuch.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ukrsuch.ukrsuch.service.ArticleService;

@Controller
@RequestMapping(value = "/articles/image.html")
public class LoadArticleImgController {
	private ArticleService articleService;

	@Autowired(required = true)
	@Qualifier(value = "articleService")
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Blob blobImg = articleService.loadArticleImgById(id);
		byte[] byteImg = null;
		try {
			byteImg = blobImg.getBytes(1, (int) blobImg.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		os.write(byteImg);
		os.close();
		
	}
}
