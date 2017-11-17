package br.ufc.quixada.IMDB_2_0.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="filmes")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=2, max=50, message="O tamanho deve ser entre {min} e {max}")
	private String nome;

	@NotNull
	private String genero;
	
	@ManyToOne
	@JoinColumn(name="diretor_id")
	private Celebridade diretor;
	
	private Integer qtdVotos = 1;
	
	private Integer totalEstrelas = 0;
	
	@NotNull
	@Min(1800) @Max(2050)
	private Integer ano;
	
	@NotNull
	@Size(min=20, max=1000, message="O tamanho deve ser entre {min} e {max}")
	private String sinopse;
	
	@NotNull
	@Min(1) @Max(5)
	private Integer estrelas;
	
	@ManyToMany
	@JoinTable(name="pertence", joinColumns=@JoinColumn(name="filme_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="celebridade_id", referencedColumnName="id"))
	private Set<Celebridade> celebridades;
	
	private String imgpath;
	
	public Filme() {}
	
	public Filme(Integer id){this.id = id;}
	
	public Filme(Integer id, String nome, String genero, Integer ano, Integer estrelas, Set<Celebridade> celebridades, Celebridade diretor){
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
		this.estrelas = estrelas;
		this.celebridades = celebridades;
		this.setDiretor(diretor);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(Integer estrelas) {
		this.estrelas = estrelas;
	}

	public Set<Celebridade> getCelebridades() {
		return celebridades;
	}

	public void setCelebridades(Set<Celebridade> celebridades) {
		this.celebridades = celebridades;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Celebridade getDiretor() {
		return diretor;
	}

	public void setDiretor(Celebridade diretor) {
		this.diretor = diretor;
	}

	public Integer getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(Integer qtdVotos) {
		this.qtdVotos = qtdVotos;
	}

	public Integer getTotalEstrelas() {
		return totalEstrelas;
	}

	public void setTotalEstrelas(Integer totalEstrelas) {
		this.totalEstrelas = totalEstrelas;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
}
