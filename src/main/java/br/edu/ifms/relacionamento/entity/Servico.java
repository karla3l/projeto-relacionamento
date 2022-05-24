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
@Table(name = "SERVICO")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "servico_name")
	private String servicoName;

	// bi-directional many-to-one association to ClienteServicoMapping
	@OneToMany(mappedBy = "servico")
	@JsonManagedReference
	private List<ClienteServicoMapping> clienteServicoMappings;

	public Servico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServicoName() {
		return this.servicoName;
	}

	public void setServicoName(String servicoName) {
		this.servicoName = servicoName;
	}

	public List<ClienteServicoMapping> getClienteServicoMappings() {
		return this.clienteServicoMappings;
	}

	public void setClienteServicoMappings(List<ClienteServicoMapping> clienteServicoMappings) {
		this.clienteServicoMappings = clienteServicoMappings;
	}

	public Servico getProjetoById(Integer id2) {
		return null;
	}}

	/*
	 * public ClienteServicoMapping addClienteServicoMapping(ClienteServicoMapping
	 * clienteServicoMapping) { getClienteServicoMappings().add(clienteServicoMapping);
	 * clienteServicoMapping.setServico(this);
	 * 
	 * return clienteServicoMapping; }
	 * 
	 * public ClienteServicoMapping removeclienteServicoMapping(ClienteServicoeMapping
	 * clienteServicoMapping) {
	 * getClienteServicoMappings().remove(clienteServicoMapping);
	 * clienteServicoMapping.setServico(null);
	 * 
	 * return clienteServicoMapping; }
	 }*/
