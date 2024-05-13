package br.com.premiumtechnology.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.premiumtechnology.model.Formacao;
import br.com.premiumtechnology.repository.FormacaoRepository;

@Service
@Transactional
public class FormacaoService {
	
	@Autowired
	private FormacaoRepository fRepository;
	
	public List<Formacao> todos(){
		return fRepository.findAll();
	}
	
	public void save(Formacao formacao) {
		fRepository.save(formacao);
	}
	
	public Formacao buscarFormacao(Long id) {
		return fRepository.findById(id).get();
	}
	
	public void excluirFormacao(Long id) {
		fRepository.deleteById(id);
	}

}
