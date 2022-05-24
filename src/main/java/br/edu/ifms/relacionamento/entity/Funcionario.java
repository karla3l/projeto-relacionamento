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

import br.edu.ifms.relacionamento.dto.FuncionarioProjetoMappingDto;

    

 @Entity
 @Table(name = "FUNCIONARIO")
 public class Funcionario implements Serializable {
 	private static final long serialVersionUID = 1L;

 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Integer id;

 	@Column(name = "first_name")
 	private String firstName;

 	@Column(name = "last_name")
 	private String lastName;

 	// bi-directional many-to-one association to FuncionarioProjetoMapping
 	@OneToMany(mappedBy = "funcionario")
 	@JsonManagedReference
 	private List<FuncionarioProjetoMappingDto> funcionarioProjetoMappings;

 	public Funcionario() {
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

 	public List<FuncionarioProjetoMappingDto> getFuncionarioProjetoMappings() {
 		return this.funcionarioProjetoMappings;
 	}

 	public void setFuncionarioProjetoMappings(List<FuncionarioProjetoMappingDto> funcionarioProjetoMappings) {
 		this.funcionarioProjetoMappings = funcionarioProjetoMappings;
 	}

 	/*public FuncionarioProjetoMapping addFuncionarioProjetoMapping(FuncionarioProjetoMapping funcionarioProjetoMapping) {
 		getFuncionarioProjetoMappings().add(funcionarioProjetoMapping);
 		funcionarioProjetoMapping.setFuncionario(this);
 		return funcionarioProjetoMapping; 
	}
 	public FuncionarioProjetoMapping removeFuncionarioProjetoMapping(FuncionarioProjetoMapping funcionarioProjetoMapping) {
 		getFuncionarioProjetoMappings().remove(funcionarioProjetoMapping);
 		funcionarioProjetoMapping.setProjeto(null);
 		return funcionarioProjetoMapping;
 	} */

 }
