package br.com.premiumtechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.premiumtechnology.model.ExperienciaProfissional;

public interface ProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {

}
