/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;

public class ServicoResponseDto {
    
	private int id;
	private String servicoName;
    private String informacoes;
    private double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServicoName() {
		return servicoName;
	}

	public void setServicoName(String servicoName) {
		this.servicoName = servicoName;
	}

    public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

    public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
