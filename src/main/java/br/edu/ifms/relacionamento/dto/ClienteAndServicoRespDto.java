/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de servicos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;
import java.util.List;

public class ClienteAndServicoRespDto extends ClienteResponseDto {
	private List<ServicoResponseDto> servicos;

	public List<ServicoResponseDto> getServico() {
		return servicos;
	}

	public void setServicos(List<ServicoResponseDto> servicos) {
		this.servicos = servicos;
	}

}

