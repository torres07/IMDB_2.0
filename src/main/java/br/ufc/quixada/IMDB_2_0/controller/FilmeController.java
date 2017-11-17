package br.ufc.quixada.IMDB_2_0.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.IMDB_2_0.model.Celebridade;
import br.ufc.quixada.IMDB_2_0.model.CheckboxParams;
import br.ufc.quixada.IMDB_2_0.model.Estrelas;
import br.ufc.quixada.IMDB_2_0.model.Filme;
import br.ufc.quixada.IMDB_2_0.repository.CelebridadeRepository;
import br.ufc.quixada.IMDB_2_0.repository.FilmeRepository;
import br.ufc.quixada.IMDB_2_0.util.FileUtil;

@Controller
public class FilmeController {
	@Autowired
	private FilmeRepository filmeRepo;
	
	@Autowired
	private CelebridadeRepository celebridadeRepo;

	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/filmes")
	public String listaFilmes(Model model){
		Iterable<Filme> lista = filmeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("filmes", lista);
		
		Iterable<Celebridade> listaC = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", listaC);
				
		model.addAttribute("check", new CheckboxParams());
				
		return "filme/lista_filmes";
	}
	
	@GetMapping("/filmes/{genero}")
	public String listaFilmesDrama(@PathVariable String genero, Model model){
		if(genero.equals("acao")) genero = "ação";
		if(genero.equals("ficcao")) genero = "ficção";
		
		String genero_ = genero.substring(0, 1).toUpperCase() + genero.substring(1);
		Iterable<Filme> listaD = filmeRepo.findByGenero(genero_);

		System.out.println(genero_);
		
		model.addAttribute("filmes", listaD);
		
		Iterable<Celebridade> listaC = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", listaC);
				
		model.addAttribute("check", new CheckboxParams());
				
		return "filme/lista_filmes";
	}
	
	@GetMapping("/filmes/{id}/rate")
	public String rateFilme(@PathVariable Integer id, Model model, Estrelas estrelas){
		Filme c = filmeRepo.findOne(id);
		
		c.setQtdVotos(c.getQtdVotos() + 1);
		c.setTotalEstrelas(c.getTotalEstrelas() + estrelas.getEstrelasN());
		c.setEstrelas( c.getTotalEstrelas() / c.getQtdVotos());
		filmeRepo.save(c);
		
		return "redirect:/filmes/" + id + "/detalhes";
	}
	
	@GetMapping("/filmes/usr")
	public String listaFilmesUsr(Model model){
		Iterable<Filme> lista = filmeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("filmes", lista);
						
		return "filme/usr/lista_filmes";
	}

	@GetMapping("/filmes/add")
	public String insereFormFilme(Model model) {
		model.addAttribute("filme", new Filme());
		
		Iterable<Celebridade> listaC = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", listaC);
		
		return "filme/insere_filme";
	}
	
	@PostMapping("/filmes")
	public String addFilme(@Valid Filme filme, BindingResult result,
			Model model, RedirectAttributes redirectAttributes, @RequestParam(value="imagem", required=false) MultipartFile imagem) throws IOException{
		
		if (imagem.getBytes().length != 0){
			FileUtil.imageSave(servletContext.getRealPath("/") + "resources/img/" + filme.getNome() + ".png", imagem);
			filme.setImgpath(filme.getNome() + ".png");
		}
		else{
			filme.setImgpath("default.png");
		}
		
		Iterable<Celebridade> listaC = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", listaC);
		
		if (result.hasErrors()){
			model.addAttribute("filme", filme);
			if (filme.getId() == null){
				return "filme/insere_filme";
			}
			else{
				return "filme/altera_filme";
			}
		}
		
		if (filme.getId() == null){
			filme.setTotalEstrelas(filme.getEstrelas());
			filmeRepo.save(filme);
			redirectAttributes.addFlashAttribute("msg", "Filme inserido com sucesso!");
		}
		else{
			if (filme.getTotalEstrelas() == 0) filme.setTotalEstrelas(filme.getEstrelas()); 
			filme.setCelebridades(filmeRepo.findOne(filme.getId()).getCelebridades());
			filmeRepo.save(filme);
			redirectAttributes.addFlashAttribute("msg", "Filme atualizado com sucesso!");
		}
		
		return "redirect:/filmes";
	}
	
	@RequestMapping("/filmes/{id}/update")
	public String alteraFormFilme(@PathVariable Integer id, Model model) {
		Filme c = filmeRepo.findOne(id);
		
		Iterable<Celebridade> listaC = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", listaC);
		
		model.addAttribute("filme", c);
		model.addAttribute("check_celebridades", new CheckboxParams());
		model.addAttribute("participantes", listaC);
		
		return "filme/altera_filme";
	}
	
	@RequestMapping("filmes/{id}/detalhes")
	public String detalhesFilmes(@PathVariable Integer id, Model model){
		Filme c = filmeRepo.findOne(id);
		model.addAttribute("filme", c);
		model.addAttribute("estrelas", new Estrelas());
		return "filme/detalhes_filme";
	}
	
	@GetMapping("/filmes/{id}/delete")
	public String deleteFilme(@PathVariable Integer id, RedirectAttributes redirectAttributes){
		Filme f = filmeRepo.findOne(id);
		
		for (Celebridade c : f.getCelebridades()){
			c.getFilmes().remove(f);
		}
		
		f.getDiretor().getDirige().remove(f);
		f.setDiretor(null);
		filmeRepo.delete(f);
		redirectAttributes.addFlashAttribute("msg", "Filme removido com sucesso!");
		return "redirect:/filmes";
	}
	
	@GetMapping("/filmes/{id}/inserir_participantes")
	public String inserirParticipantes(@PathVariable Integer id, Model model, CheckboxParams checkboxParams){
		
		Filme f = filmeRepo.findOne(id);
		
		for (Integer i : checkboxParams.getSelectedCelebridades()){
			Celebridade c = celebridadeRepo.findOne(i);
			f.getCelebridades().add(c);
		}
				
		filmeRepo.save(f);
		
		return "redirect:/filmes";
	}
	
	@GetMapping("/filmes/{id}/remover_participantes")
	public String removerParticipantes(@PathVariable Integer id, Model model, CheckboxParams checkboxParams){
		Filme f = filmeRepo.findOne(id);
		
		for (Integer i : checkboxParams.getSelectedCelebridades()){
			f.getCelebridades().remove(celebridadeRepo.findOne(i));
		}
		
		filmeRepo.save(f);
		
		return "redirect:/filmes";
	}
}
