package br.edu.ifms.relacionamento.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.edu.ifms.relacionamento.model.Projeto;


@Entity
@Table(name = "FUNCIONARIO_PROJETO_MAPPING")
public class FuncionarioProjetoMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "FUNCIONARIO_ID")
	private Integer funcionarioId;

	@Column(name = "PROJETO_ID")
	private Integer projetoId;

	// bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "FUNCIONARIO_ID", insertable = false, updatable = false)
	private Funcionario funcionario;

	// bi-directional many-to-one association to Projeto
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "PROJETO_ID", insertable = false, updatable = false)
	private Projeto projeto;

	public FuncionarioProjetoMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Integer getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(Integer projetoId) {
		this.projetoId = projetoId;
	}

}