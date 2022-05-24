package br.edu.ifms.relacionamento.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PROJETO")
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "pojeto_name")
	private String projetoName;

	// bi-directional many-to-one association to FuncionarioProjetoMapping
	@OneToMany(mappedBy = "projeto")
	@JsonManagedReference
	private List<FuncionarioProjetoMapping> funcionarioProjetoMappings;

	public Projeto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjetoName() {
		return this.projetoName;
	}

	public void setProjetoName(String projetoName) {
		this.projetoName = projetoName;
	}

	public List<FuncionarioProjetoMapping> getFuncionarioProjetoMappings() {
		return this.funcionarioProjetoMappings;
	}

	public void setFuncionarioProjetoMappings(List<FuncionarioProjetoMapping> funcionarioProjetoMappings) {
		this.funcionarioProjetoMappings = funcionarioProjetoMappings;
	}

	public Projeto getProjetoById(Integer id2) {
		return null;
	}}

	/*
	 * public FuncionarioProjetoMapping addFuncionarioProjetoMapping(FuncionarioProjetoMapping
	 * funcionarioProjetoMapping) { getFuncionarioProjetoMappings().add(funcionarioProjetoMapping);
	 * funcionarioProjetoMapping.setProjeto(this);
	 * 
	 * return funcionarioProjetoMapping; }
	 * 
	 * public FuncionarioProjetoMapping removefuncionarioProjetoMapping(FuncionarioProjetoeMapping
	 * funcionarioProjetoMapping) {
	 * getFuncionarioProjetoMappings().remove(funcionarioProjetoMapping);
	 * funcionarioProjetoMapping.setProjeto(null);
	 * 
	 * return funcionarioProjetoMapping; }
	 }*/


 