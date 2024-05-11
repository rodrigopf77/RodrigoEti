package br.com.premiumtechnology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.premiumtechnology.model.LinguagensFramworks;
import br.com.premiumtechnology.repository.Linguagens;

@Service
@Transactional
public class LinguagemService {
	
	@Autowired
	private Linguagens rep;
	
	public List<LinguagensFramworks> todos(){
		return rep.findAll();
	}
	
	public void save(LinguagensFramworks linguagem) {
		rep.save(linguagem);
	}
	
	public LinguagensFramworks buscarLinguagem(Long id) {
		return rep.findById(id).get();
	}
	
	public void excluirLinguagem(Long id) {
		rep.deleteById(id);
	}

}
