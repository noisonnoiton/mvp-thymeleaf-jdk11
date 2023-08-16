package com.ski.mvp.thymeleaf.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ski.mvp.thymeleaf.util.AuthUtil;

@Controller
public class HomeController {

	@Value("${api.backend.url}")
	private String apiBackend;

	@Autowired
	private AuthUtil authUtil;

	String pagePrefix = "pages/";

	@GetMapping({"","/","/index","/home"})
	public String index(HttpServletRequest request, Model model) throws IOException {
		return pagePrefix + "index";
	}

	@GetMapping("/grid")
	public String grid(HttpServletRequest request, Model model) throws IOException {

		model.addAttribute("apiBackend", apiBackend);

		return pagePrefix + "grid";
	}

	@GetMapping("/chart")
	public String chart(HttpServletRequest request, Model model) throws IOException {

		model.addAttribute("apiBackend", apiBackend);

		return pagePrefix + "chart";
	}

	@GetMapping("/auth")
	public String auth(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		authUtil.checkCookieAuth(request, response);
		
		return pagePrefix + "auth";
	}

	@GetMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		return pagePrefix + "test";
	}

	@GetMapping("/notauth")
	@ResponseStatus(code = org.springframework.http.HttpStatus.UNAUTHORIZED)
	public String notauth(HttpServletRequest request, Model model) {
		
		return pagePrefix + "notauth";
	}

}
