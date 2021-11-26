package br.com.barter.APIbarter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}

}
