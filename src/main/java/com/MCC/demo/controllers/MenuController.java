package com.MCC.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@RequestMapping("/")
	public String index() {
		return "menu/index";
	}
}
