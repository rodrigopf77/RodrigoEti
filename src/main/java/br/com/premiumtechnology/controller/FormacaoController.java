package br.com.premiumtechnology.controller;

//TESTE2.1
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.premiumtechnology.model.Empresa;
import br.com.premiumtechnology.model.Formacao;
import br.com.premiumtechnology.service.EmpresaService;
import br.com.premiumtechnology.service.FormacaoService;

@Controller
@RequestMapping("/formacao")
public class FormacaoController {
		
		@Autowired
		private FormacaoService fService;
		@Autowired
		private EmpresaService eService;
		
		@RequestMapping("adicionar")
		public ModelAndView addFormacao(Formacao formacao) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("cadastroformacao"); 
			mv.addObject("formacao", formacao);

			List<Empresa> empresas = eService.todos();
			mv.addObject("lista_empresa", empresas);

			return mv;
		}
		
		@RequestMapping(value = "save", method = RequestMethod.POST)
		public String salvar(Formacao formacao) {
			try {
				System.out.println("Cheguei no SAVE: " + formacao.getFormaco());
				fService.save(formacao);
				return "redirect:/formacao/listar";
			}catch(Exception e) {
				e.printStackTrace();
			}
			return "redirect:/formacao/listar";
		}
		
		@RequestMapping("listar")
		public String home(Model model) {
			List<Formacao> listaFormacao = fService.todos();
			for (Formacao formacao : listaFormacao) {
				System.out.println("Cheguei no SAVE: " + formacao.getEmpresa().getNomeFantasia());
				
			}
			model.addAttribute("listaFormacao", listaFormacao);
			
			return "formacao";
		}
		
		@RequestMapping("editar/{id}")
		public ModelAndView editar(@PathVariable("id") Long id) {
			return addFormacao(fService.buscarFormacao(id));
		}
		
		@RequestMapping("/delete/{id}")
		public ModelAndView delete(@PathVariable("id") Long id) {
			fService.excluirFormacao(id);
			
			ModelAndView mv = new ModelAndView("redirect:/formacao/listar");
			
			return mv;
		}

}
