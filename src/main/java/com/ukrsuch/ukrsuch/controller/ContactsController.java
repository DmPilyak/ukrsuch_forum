package com.ukrsuch.ukrsuch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsController {

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String contacts(HttpServletRequest request, HttpServletResponse response) {

		return "contactsPage";
	}
}
