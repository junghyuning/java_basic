package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//REST(Representational State Transfer) : 자원(Resource)의 표현에 의한 상태를 전달하는 것

@Controller("/rest")
public class RestfulController {
	@GetMapping("/join")
	public String join() {
		return "rest/input";
	}
	@PostMapping("/join")
	public String join(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
}
