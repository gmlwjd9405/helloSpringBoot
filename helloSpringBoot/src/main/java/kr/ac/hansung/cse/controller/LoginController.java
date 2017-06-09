package kr.ac.hansung.cse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.cse.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLoginPage(Model model, @RequestParam String username, @RequestParam String password) {

		// 사용자가 form에 입력한 내용을 가져와 DB에서 조회하여 일치하는지를 확인
		boolean isValidUser = service.validateUser(username, password);

		if (!isValidUser) {
			model.addAttribute("errorMsg", "Invalid username and password");
			return "login";
		}

		model.addAttribute("name", username);
		return "welcome";
	}
}
