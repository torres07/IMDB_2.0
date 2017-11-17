package br.ufc.quixada.IMDB_2_0.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.ufc.quixada.IMDB_2_0.interceptor.InterceptadorGeral;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private InterceptadorGeral interceptadorGeral;
	
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(interceptadorGeral);
	}
}
