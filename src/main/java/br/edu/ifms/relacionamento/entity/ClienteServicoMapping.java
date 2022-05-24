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

import br.edu.ifms.relacionamento.model.Servico;


@Entity
@Table(name = "CLIENTE_SERVICO_MAPPING")
public class ClienteServicoMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CLIENTE_ID")
	private Integer clienteId;

	@Column(name = "SERVICO_ID")
	private Integer servicoId;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "CLIENTE_ID", insertable = false, updatable = false)
	private Cliente cliente;

	// bi-directional many-to-one association to Servico
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "SERVICO_ID", insertable = false, updatable = false)
	private Servico servico;

	public ClienteServicoMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

}
