package br.ufc.quixada.IMDB_2_0.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
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
import br.ufc.quixada.IMDB_2_0.model.Filme;
import br.ufc.quixada.IMDB_2_0.repository.CelebridadeRepository;
import br.ufc.quixada.IMDB_2_0.util.FileUtil;

@Controller
public class CelebridadeController {
	@Autowired
	private CelebridadeRepository celebridadeRepo;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private EntityManager em;
	
	@GetMapping("/celebridades")
	public String listaCelebridades(Model model){
		Iterable<Celebridade> lista = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", lista);
		return "celebridade/lista_celebridades";
	}
	
	@GetMapping("/celebridades/usr")
	public String listaCelebridadesUsr(Model model){
		Iterable<Celebridade> lista = celebridadeRepo.findAll
				(new Sort(new Sort.Order(Sort.Direction.ASC, "nome")));
		model.addAttribute("celebridades", lista);
		return "celebridade/usr/lista_celebridades";
	}
	
	@GetMapping("/celebridades/add")
	public String insereFormCelebridade(Model model){
		model.addAttribute("celebridade", new Celebridade());
		return "celebridade/insere_celebridade";
	}
	
	@PostMapping("/celebridades")
	public String addCelebridade(@Valid Celebridade celebridade, BindingResult result,
			Model model, RedirectAttributes redirectAttributes, @RequestParam(value="imagem", required=false) MultipartFile imagem) throws IOException{
		
		if (imagem.getBytes().length != 0){
			FileUtil.imageSave(servletContext.getRealPath("/") + "resources/img/" + celebridade.getNome() + ".png", imagem);
			celebridade.setImgpath(celebridade.getNome() + ".png");
		}
		else{
			celebridade.setImgpath("default.png");
		}
		
		if (result.hasErrors()){
			model.addAttribute("celebridade", celebridade);
			if (celebridade.getId() == null){
				return "celebridade/insere_celebridade";
			}
			else{
				return "celebridade/altera_celebridade";
			}
		}
		
		if (celebridade.getId() == null){
			celebridadeRepo.save(celebridade);
			redirectAttributes.addFlashAttribute("msg", "Celebridade inserida com sucesso!");
		}
		else{
			celebridadeRepo.save(celebridade);
			redirectAttributes.addFlashAttribute("msg", "Celebridade atualizada com sucesso!");
		}
		
		return "redirect:/celebridades";
	}
	
	@RequestMapping("/celebridades/{id}/update")
	public String alteraFormCelebridade(@PathVariable Integer id, Model model) {
		Celebridade c = celebridadeRepo.findOne(id);
		model.addAttribute("celebridade", c);
		return "celebridade/altera_celebridade";
	}
	
	@GetMapping("/celebridades/{id}/delete")
	public String deleteCelebridade(@PathVariable Integer id, RedirectAttributes redirectAttributes){
		Celebridade c = celebridadeRepo.findOne(id);
		Filme f = null;

		for (Filme filme : c.getDirige()){
			f = (Filme) em.find(Filme.class, filme.getId());
			f.setDiretor(null);
		}
		
		for (Filme filme : c.getFilmes()){
			f = (Filme) em.find(Filme.class, filme.getId());
			f.getCelebridades().remove(c);
		}
		
		celebridadeRepo.delete(c);
		redirectAttributes.addFlashAttribute("msg", "Celebridade removida com sucesso!");
		return "redirect:/celebridades";
	}
	
	@RequestMapping("celebridades/{id}/detalhes")
	public String detalhesFilmes(@PathVariable Integer id, Model model){
		Celebridade c = celebridadeRepo.findOne(id);
		model.addAttribute("celebridade", c);
		return "celebridade/detalhes_celebridade";
	}
	
}
