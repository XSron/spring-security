package springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	@PostMapping("/csrf")
	public String crossSitePage() {
		return "cross-site-page";
	}
}
