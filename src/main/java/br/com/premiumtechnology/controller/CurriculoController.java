package br.com.premiumtechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.premiumtechnology.model.ExperienciaProfissional;
import br.com.premiumtechnology.model.Formacao;
import br.com.premiumtechnology.model.LinguagensFramworks;
import br.com.premiumtechnology.model.Produto;
import br.com.premiumtechnology.service.CursoService;
import br.com.premiumtechnology.service.EmpresaService;
import br.com.premiumtechnology.service.FormacaoService;
import br.com.premiumtechnology.service.LinguagemService;
import br.com.premiumtechnology.service.ProfissionalService;

@Controller
@RequestMapping("/curriculo")
public class CurriculoController {
	
	@Autowired
	private ProfissionalService pService;
	@Autowired
	private EmpresaService eService;
	
	@Autowired
	private FormacaoService fService;
	
	@Autowired
	private LinguagemService lService;
	
	@Autowired
	private CursoService cService;

	@RequestMapping("listar")
	public String home(Model model) {
		List<ExperienciaProfissional> listaExperiencias = pService.todos();
		model.addAttribute("listaExperiencia", listaExperiencias);
		
		List<LinguagensFramworks> listaLinguagens = lService.todos();
		model.addAttribute("listaLinguagem", listaLinguagens);
		
		List<Formacao> listaFormacao = fService.todos();
		model.addAttribute("listaFormacao", listaFormacao);
		
		List<Produto> listaCursos = cService.todos();
		model.addAttribute("listaCurso", listaCursos);
		return "curriculo";
	}
	
}
