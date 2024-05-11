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
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_curso")
	private long id;
	
	@Column(name= "nome_curso")
	private String nome;
	
	@Column(name="nivel_curso")
	private String nivel;
	
	//mappedBy reference an unknown target entity property: br.com.rodrigofernandes.model.Produto.empresa 
		//in br.com.rodrigofernandes.model.Empresa.experiencias
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curso_empresa_id", referencedColumnName = "id")
	private Empresa instituicao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Empresa getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Empresa instituicao) {
		this.instituicao = instituicao;
	}
}
