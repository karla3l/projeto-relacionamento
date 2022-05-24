/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;
import java.util.List;

public class FuncionarioAndProjetoRespDto extends FuncionarioResponseDto {
	private List<ProjetoResponseDto> projetos;

	public List<ProjetoResponseDto> getProjeto() {
		return projetos;
	}

	public void setProjetos(List<ProjetoResponseDto> projetos) {
		this.projetos = projetos;
	}

}