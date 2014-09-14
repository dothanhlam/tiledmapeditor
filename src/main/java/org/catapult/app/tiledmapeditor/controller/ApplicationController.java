package org.catapult.app.tiledmapeditor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {

	public ApplicationController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String defaultHandler() {
		return "index.html";
	}
}
