package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ukrsuch.ukrsuch.model.UserModel;
import com.ukrsuch.ukrsuch.service.UserService;

@Controller
public class SignInController {
	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", new UserModel());
		return new ModelAndView("signInPage", "user", new UserModel());
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String submit(@ModelAttribute("user") UserModel newUser, ModelMap model,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String repPass = request.getParameter("repPass");
		UserModel user = userService.getUserByNik(newUser.getNik());
		if (user != null) {
			request.setAttribute("message", "Цей нікнейм вже використвується.");
			return "signInPage";
		} else if (!repPass.equals(newUser.getPassword())) {
			request.setAttribute("message", "Неправильний повторний пароль.");
			return "signInPage";
		} else if (newUser.getEmail() != null && newUser.getNik() != null && newUser.getPassword() != null
				&& newUser.getEmail() != "" && newUser.getNik() != "" && newUser.getPassword() != "") {
			userService.addUser(newUser);
			UserModel thisUser = userService.getUserByNik(newUser.getNik());
			redirectAttributes.addFlashAttribute("user", thisUser);
			session.setAttribute("user", thisUser);
			return "redirect:/home";
		} else {
			return "signInPage";
		}
	}

}
