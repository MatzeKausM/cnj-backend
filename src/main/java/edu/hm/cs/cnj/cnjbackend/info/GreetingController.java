package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@RequestMapping("/info")
	public Info greeting() {
		Info result = new Info();
		result.setMessage("OK");
		return result;
	}
}