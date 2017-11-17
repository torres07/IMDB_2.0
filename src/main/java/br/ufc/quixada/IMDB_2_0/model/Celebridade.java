package br.ufc.quixada.IMDB_2_0.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="celebridades")
public class Celebridade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=4, max=50, message="O tamanho deve ser entre {min} e {max}")
	private String nome;

	@NotNull
	@Size(min=10, max=150, message="O tamanho deve ser entre {min} e {max}")
	private String descricao;
	
	@NotNull
	@Size(min=4, max=50, message="O tamanho deve ser entre {min} e {max}")
	private String curiosidade;
	
	@ManyToMany(mappedBy="celebridades")
	private Set<Filme> filmes;
	
	@OneToMany(mappedBy="diretor")
	private Set<Filme> dirige;
		
	private String imgpath;
	
	public Celebridade(Integer id, String nome, String descricao, String curiosidade){
		this.setId(id);
		this.nome = nome;
		this.descricao = descricao;
		this.curiosidade = curiosidade;		
	}
	
	public Celebridade(){}
	
	public Celebridade(Integer id){this.id = id;}
	
	public void setCuriosidade(String curiosidade) {
		this.curiosidade = curiosidade;
	}
	
	public String getCuriosidade() {
		return curiosidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return "";		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Filme> getDirige() {
		return dirige;
	}

	public void setDirige(Set<Filme> dirige) {
		this.dirige = dirige;
	}

	public Set<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(Set<Filme> filmes) {
		this.filmes = filmes;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

}
