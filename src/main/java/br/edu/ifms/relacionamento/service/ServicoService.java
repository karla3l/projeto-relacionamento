package br.edu.ifms.relacionamento.service;

import br.edu.ifms.relacionamento.dto.ServicoRequestDto;
import br.edu.ifms.relacionamento.dto.ServicoResponseDto;

public interface ServicoService {
	public ServicoResponseDto createServico(ServicoRequestDto servicoDto);
} 