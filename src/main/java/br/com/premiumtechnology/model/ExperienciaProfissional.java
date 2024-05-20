 package br.com.premiumtechnology.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExperienciaProfissional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_experiencia")
	private long id;
	
	@Column(name= "cargo")
	private String cargo;
	
	@Column(name= "funcao")
	private String funcao;
	
	//mappedBy reference an unknown target entity property: br.com.rodrigofernandes.model.Produto.empresa 
	//in br.com.rodrigofernandes.model.Empresa.experiencias
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="experiencia_empresa_id", referencedColumnName = "id")
	private Empresa empresa;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
