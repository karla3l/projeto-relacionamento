/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;

public class ProjetoResponseDto {
    
	private int id;
	private String projetoName;
	private String informacoes;
	private int tempoDuracao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjetoName() {
		return projetoName;
	}

	public void setProjetoName(String projetoName) {
		this.projetoName = projetoName;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public int getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(int tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

}
