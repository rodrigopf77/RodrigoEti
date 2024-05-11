package br.com.premiumtechnology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.premiumtechnology.model.Empresa;

public interface Empresas extends JpaRepository<Empresa, Long>{
	
	List<Empresa> findByNome(String nome);
	List<Empresa> findBySegmento(String segmento);
	List<Empresa> findByEstado(String estado);

}