/* Lembrete: Data Transfer Object (DTO) ou simplesmente Transfer Object é um padrão de servicos bastante
 usado em Java para o transporte de dados entre diferentes componentes de um sistema, diferentes
instâncias ou processos de um sistema distribuído ou diferentes sistemas via serialização.

A ideia consiste basicamente em agrupar um conjunto de atributos numa 
classe simples de forma a otimizar a comunicação. */

package br.edu.ifms.relacionamento.dto;

public class ServicoRequestDto {
    

	private String servicoName;

	public String getServicoName() {
		return servicoName;
	}

	public void setServicoName(String servicoName) {
		this.servicoName = servicoName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((servicoName == null) ? 0 : servicoName.hashCode());
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
		ServicoRequestDto other = (ServicoRequestDto) obj;
		if (servicoName == null) {
			if (other.servicoName != null)
				return false;
		} else if (!servicoName.equals(other.servicoName))
			return false;
		return true;
	}

}
