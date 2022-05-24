/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de projetos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;

public class ProjetoRequestDto {
    

	private String projetoName;

	public String getProjetoName() {
		return projetoName;
	}

	public void setProjetoName(String projetoName) {
		this.projetoName = projetoName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projetoName == null) ? 0 : projetoName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetoRequestDto other = (ProjetoRequestDto) obj;
		if (projetoName == null) {
			if (other.projetoName != null)
				return false;
		} else if (!projetoName.equals(other.projetoName))
			return false;
		return true;
	}

}