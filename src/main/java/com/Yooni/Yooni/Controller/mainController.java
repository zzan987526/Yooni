package com.Yooni.Yooni.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class mainController {
	
	@RequestMapping(value = "/home")
	public String home() {
		return "index";
	}
	
}
