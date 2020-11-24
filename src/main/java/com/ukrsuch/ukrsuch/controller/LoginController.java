package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		//System.out.println("******* "+ request.getRe);
		String nik = request.getParameter("nik");
		String password = request.getParameter("pass");
		UserModel user = userService.getUserByNik(nik);
		if (user != null && password.equals(user.getPassword())) {
			session.setAttribute("user", user);
			return "redirect:/home";
		} else {
			request.setAttribute("message", "Невірний нікнейм або пароль. Спробуйте ще раз!");
			return "registrPage";
		}
	}

}
