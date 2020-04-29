package springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleController {
	@GetMapping("/sale")
	public String salePage() {
		return "sale";
	}
}
