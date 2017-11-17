package br.ufc.quixada.IMDB_2_0.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class InterceptadorGeral extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String URI = request.getRequestURI();
		System.out.println(URI);
		
		List<String> permitidos = new ArrayList<String>();
		
		permitidos.add("/login");
		permitidos.add("/cadastro_usuario");
		permitidos.add("/finalizar_cadastro");
		permitidos.add("/efetuar_login");
		permitidos.add("/logout");
		permitidos.add("/filmes");
		permitidos.add("/celebridades");
		permitidos.add("/about");
		
		permitidos.add("/");
		
		if (permitidos.contains(URI) || URI.endsWith("/detalhes")){
			return true;
		}
		
		if (request.getSession().getAttribute("usuario_logado") != null){
			if (!request.getSession().getAttribute("login").equals("admin")){
				if (URI.contains("update") || URI.contains("add") || URI.contains("delete")){
					response.sendRedirect("/");
					return false;
				}
			}
			return true;
		}
		
		response.sendRedirect("/");
		return false;
	}
}
