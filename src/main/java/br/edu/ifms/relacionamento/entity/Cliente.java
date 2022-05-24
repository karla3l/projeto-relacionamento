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

import br.edu.ifms.relacionamento.dto.ClienteServicoMappingDto;

    

 @Entity
 @Table(name = "CLIENTE")
 public class Cliente implements Serializable {
 	private static final long serialVersionUID = 1L;

 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer id;

 	@Column(name = "first_name")
 	private String firstName;

 	@Column(name = "last_name")
 	private String lastName;

 	// bi-directional many-to-one association to ClienteServicoMapping
 	@OneToMany(mappedBy = "cliente")
 	@JsonManagedReference
 	private List<ClienteServicoMappingDto> clienteServicoMappings;

 	public Cliente() {
 	}

 	public Integer getId() {
 		return this.id;
 	}

 	public void setId(Integer id) {
 		this.id = id;
 	}

 	public String getFirstName() {
 		return this.firstName;
 	}

 	public void setFirstName(String firstName) {
 		this.firstName = firstName;
 	}

 	public String getLastName() {
 		return this.lastName;
 	}

 	public void setLastName(String lastName) {
 		this.lastName = lastName;
 	}

 	public List<ClienteServicoMappingDto> getClienteProdutoMappings() {
 		return this.clienteServicoMappings;
 	}

 	public void setClienteProdutoMappings(List<ClienteServicoMappingDto> clienteProdutoMappings) {
 		this.clienteServicoMappings = clienteProdutoMappings;
 	}

    /*public ClienteServicoMapping addClienteServicoMapping(ClienteServicoMapping clienteServicoMapping) {
 		getClienteServicoMappings().add(clienteServicoMapping);
 		clienteServicoMapping.setCliente(this);
 		return clienteServicoMapping; 
	}
 	public ClienteServicoMapping removeClienteServicoMapping(ClienteServicoMapping clienteServicoMapping) {
 		getClienteServicoMappings().remove(clienteServicoMapping);
 		clienteServicoMapping.setServico(null);
 		return clienteServicoMapping;
 	} */


 }
