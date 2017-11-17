package br.ufc.quixada.IMDB_2_0.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=4, max=12, message="O tamanho deve ser entre {min} e {max}")
	private String login;
	
	@NotNull
	@Size(min=8, max=40, message="O tamanho deve ser entre {min} e {max}")
	private String password;
	
	@NotNull
	@Size(min=8, max=40, message="O tamanho deve ser entre {min} e {max}")
	private String email;
	
	public Usuario(Integer id, String login, String password, String email){
		this.id = id;
		this.login = login;
		this.password = password;
		this.setEmail(email);
	}
	
	public Usuario(Integer id) {this.id = id;}
	
	public Usuario() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
