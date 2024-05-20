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
public class Formacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_formacao")
	private long id;
	
	@Column(name= "formaco")
	private String formaco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="experiencia_empresa_id", referencedColumnName = "id")
	private Empresa empresa;

	/*private LocalDate ano;*/
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFormaco() {
		return formaco;
	}

	public void setFormaco(String formaco) {
		this.formaco = formaco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
