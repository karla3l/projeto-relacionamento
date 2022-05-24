package br.edu.ifms.relacionamento.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.relacionamento.dto.ProjetoRequestDto;
import br.edu.ifms.relacionamento.dto.ProjetoResponseDto;
import br.edu.ifms.relacionamento.entity.Projeto;
import br.edu.ifms.relacionamento.repository.ProjetoRepository;
import br.edu.ifms.relacionamento.service.ProjetoService;


@Service
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Override
	@Transactional
	public ProjetoResponseDto createProjeto(ProjetoRequestDto projetoDto) {
		Projeto projeto = new Projeto();
		projeto.setProjetoName(projetoDto.getProjetoName());
		projeto = projetoRepository.save(projeto);

		ProjetoResponseDto dto = new ProjetoResponseDto();
		dto.setProjetoName(projeto.getProjetoName());
		dto.setId(projeto.getId());

		return dto;
	}

}