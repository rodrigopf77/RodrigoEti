package br.com.premiumtechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.premiumtechnology.model.Produto;

public interface CursoRepository extends JpaRepository<Produto, Long> {

}
