package springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ITController {
	@GetMapping("/it")
	public String itPage() {
		return "it";
	}
}
