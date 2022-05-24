/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;
import java.util.Set;

public class FuncionarioProjetoMappingDto {
    
	private Integer funcionarioId;
	private Set<Integer> projetoIds;

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Set<Integer> getProjetoIds() {
		return projetoIds;
	}

	public void setProjetoIds(Set<Integer> projetoIds) {
		this.projetoIds = projetoIds;
	}

}