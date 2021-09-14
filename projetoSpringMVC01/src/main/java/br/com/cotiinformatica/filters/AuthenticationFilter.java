package br.com.cotiinformatica.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// tratamento para atualizar estes objetos request e response para
		// os tipos: HttpServletRequest e HttpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// definir quais são as URLs permitidas no sistema
		// não precisam que o usuario esteja autenticado..
		List<String> urlsPermitidas = new ArrayList<String>();

		urlsPermitidas.add("/");
		urlsPermitidas.add("/login");
		urlsPermitidas.add("/register");
		urlsPermitidas.add("/autenticar-usuario");
		urlsPermitidas.add("/cadastrar-usuario");
		urlsPermitidas.add("/password-recover");

		// verificando se a requisição que o FILTER esta interceptando
		// não é de nenhuma das URLs contidas na lista
		if (!urlsPermitidas.contains(req.getServletPath())) {

			// verificar se o usuario não esta autenticado em sessão (user_auth)
			if (req.getSession().getAttribute("user_auth") == null) {
				// redirecionar para a página inicial do projeto
				resp.sendRedirect("/projetoSpringMVC01/");
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}
