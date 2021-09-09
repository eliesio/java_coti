package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

	@RequestMapping("/") // raiz do projeto
	public ModelAndView login() {
		// WEB-INF/views/account/login.jsp
		ModelAndView modelAndView = new ModelAndView("account/login");
		return modelAndView;
	}

	@RequestMapping("/register") // cadastro de usuário
	public ModelAndView register() {
		// WEB-INF/views/account/register.jsp
		ModelAndView modelAndView = new ModelAndView("account/register");
		return modelAndView;
	}

	@RequestMapping("/password-recover") // cadastro de usuário
	public ModelAndView passwordrecover() {
		// WEB-INF/views/account/passwordrecover.jsp
		ModelAndView modelAndView = new ModelAndView("account/passwordrecover");
		return modelAndView;
	}

}






