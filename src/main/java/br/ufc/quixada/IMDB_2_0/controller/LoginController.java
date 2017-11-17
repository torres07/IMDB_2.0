package br.ufc.quixada.IMDB_2_0.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.IMDB_2_0.dao.UsuarioJpaDao;
import br.ufc.quixada.IMDB_2_0.model.Usuario;
import br.ufc.quixada.IMDB_2_0.repository.UsuarioRepository;

@Controller
public class LoginController {
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private UsuarioJpaDao usuarioRepoJPA;
	
	@PostMapping("/finalizar_cadastro")
	public String finalizarCadastroUser(@Valid Usuario usuario, BindingResult result,
			Model model, RedirectAttributes redirectAttributes){
		
		if (result.hasErrors()){
			model.addAttribute("usuario", usuario);
			if (usuario.getId() == null){
				return "usuario/insere_usuario";
			}
			else{
				return "usuario/altera_usuario";
			}
		}
		if (usuario.getId() == null){
			if (usuarioRepoJPA.getUsuarioByEmail(usuario.getEmail()) == null &&
					usuarioRepoJPA.getUsuarioByLogin(usuario.getLogin()) == null){
				usuarioRepo.save(usuario);
				redirectAttributes.addFlashAttribute("msg", "Usuário cadastrado com sucesso!");
			}
			else{
				redirectAttributes.addFlashAttribute("msg", "Este login ou email já esta sendo usado!");
			}			
		}
		else{
			if (usuarioRepoJPA.getUsuarioByEmail(usuario.getEmail()) == null &&
					usuarioRepoJPA.getUsuarioByLogin(usuario.getLogin()) == null){
				usuarioRepo.save(usuario);
				redirectAttributes.addFlashAttribute("msg", "Usuário atualizado com sucesso!");
			}
			else{
				redirectAttributes.addFlashAttribute("msg", "Este login ou email já esta sendo usado!");
			}
		}
		return "redirect:/cadastro_usuario";
	}
	
	@GetMapping("/cadastro_usuario")
	public String insereUser(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuario/insere_usuario";
	}
	
	@RequestMapping("/efetuar_login")
	public String buscarUsuarioLogin(Model model, Usuario usuario,
			HttpServletRequest request, HttpServletResponse response, HttpSession session,
			RedirectAttributes redirectAttributes){
		
		Usuario u = usuarioRepoJPA.getUsuarioByLogin(usuario.getLogin());
		if (u != null){
			if (u.getPassword().equals(usuario.getPassword())){
				session.setAttribute("login", usuario.getLogin());
				session.setAttribute("usuario_logado", usuario);
				redirectAttributes.addFlashAttribute("msg", "Login efetuado com sucesso!");
				return "redirect:/filmes";
			}			
		}
		redirectAttributes.addFlashAttribute("msg", "Login ou senha incorretos!");
		return "redirect:/login";		
	}
	
	@GetMapping("/login")
	public String efetuarLogin(Model model){
		return "login/login";
	}
	
	@GetMapping("/logout")
	public String efetuarLogout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
}
