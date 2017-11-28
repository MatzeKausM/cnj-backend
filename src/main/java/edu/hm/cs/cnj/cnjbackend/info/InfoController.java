package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/info")
public class InfoController {
	@Autowired
	InfoProperties properties;

	@GetMapping
	public Info getInfo() {
		Info result = new Info();
		result.setMessage(properties.getMessage());
		return result;
	}
}
