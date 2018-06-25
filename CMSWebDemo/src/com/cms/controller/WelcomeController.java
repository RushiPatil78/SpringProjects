package com.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	
	@RequestMapping(value="/hello",method = RequestMethod.GET)
	public String sayHello(ModelMap modelMap) {
		modelMap.put("message", "Good Afternoon!..");		
		return "message";
	}
	
	
}
