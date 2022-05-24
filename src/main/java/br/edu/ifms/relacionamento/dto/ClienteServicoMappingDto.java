/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de servicos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;
import java.util.Set;

public class ClienteServicoMappingDto {
    
	private Integer clienteId;
	private Set<Integer> servicoIds;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Set<Integer> getServicoIds() {
		return servicoIds;
	}

	public void setServicoIds(Set<Integer> servicoIds) {
		this.servicoIds = servicoIds;
	}

}

