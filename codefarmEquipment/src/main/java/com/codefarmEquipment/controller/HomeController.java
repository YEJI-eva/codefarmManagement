package com.codefarmEquipment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String test() {
		return "index";
	}
}