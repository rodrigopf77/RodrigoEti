package br.com.premiumtechnology.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.premiumtechnology.model.Empresa;
import br.com.premiumtechnology.model.ExperienciaProfissional;
import br.com.premiumtechnology.service.EmpresaService;
import br.com.premiumtechnology.service.ProfissionalService;

@Controller
@RequestMapping("/experiencia")
public class ExperienciaProfissionalController {
	
	@Autowired
	private ProfissionalService pService;
	@Autowired
	private EmpresaService eService;
	
	@RequestMapping("adicionar")
	public ModelAndView addExperiencia(ExperienciaProfissional experiencia) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cadastroprofissional");
		mv.addObject("experiencia", experiencia);
		
		List<Empresa> empresas = eService.todos();
		mv.addObject("lista_empresa", empresas);
		
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String salvar(ExperienciaProfissional experiencia) {
		pService.save(experiencia);
		return "redirect:/experiencia/listar";
	}
	
	@RequestMapping("listar")
	public String home(Model model) {
		List<ExperienciaProfissional> listaExperiencias = pService.todos();
		model.addAttribute("listaExperiencia", listaExperiencias);
		return "experiencias";
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return addExperiencia(pService.buscarExperiencia(id));
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		pService.excluirExperiencia(id);
		
		ModelAndView mv = new ModelAndView("redirect:/experiencia/listar");
		
		return mv;
	}

}
