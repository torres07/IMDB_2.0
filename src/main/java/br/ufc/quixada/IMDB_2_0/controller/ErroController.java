package br.ufc.quixada.IMDB_2_0.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErroController implements ErrorController{
	private static final String PATH = "/error";
	
	@RequestMapping(value = PATH)
	public String error(){
		String r = "<h2>Infelizmente aconteceu algum erro :(</h2>";
		r += "<p>Desculpe nos pela a incoveniência, estamos trabalhando para consertar esse tipo de problema.</p>";
		r += "<p><a href=\"/\">Clique aqui</a> para começarmos de novo :)</p>";
		return r;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
