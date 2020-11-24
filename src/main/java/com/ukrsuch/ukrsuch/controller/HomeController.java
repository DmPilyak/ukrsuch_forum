package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.UserService;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String listArticles(Model model, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("user", session.getAttribute("user"));
		return "homePage";
	}
	
}
