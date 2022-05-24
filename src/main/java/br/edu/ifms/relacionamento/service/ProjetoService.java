package br.edu.ifms.relacionamento.service;

import br.edu.ifms.relacionamento.dto.ProjetoRequestDto;
import br.edu.ifms.relacionamento.dto.ProjetoResponseDto;

public interface ProjetoService {
	public ProjetoResponseDto createProjeto(ProjetoRequestDto projetoDto);
} 