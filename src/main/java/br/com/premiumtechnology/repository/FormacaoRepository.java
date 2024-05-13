package br.com.premiumtechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.premiumtechnology.model.Formacao;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {

}
