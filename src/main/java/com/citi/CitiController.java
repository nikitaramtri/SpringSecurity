package com.citi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiController {

	@GetMapping(value="/helloall")
	public String helloAll() {
		return "Hello All";
	}
	@GetMapping(value="/hellouser")
	public String helloUser() {
		return "Hello User";
	}
	@GetMapping(value="/helloadmin")
	public String helloAdmin() {
		return "Hello Admin";
	}
}
