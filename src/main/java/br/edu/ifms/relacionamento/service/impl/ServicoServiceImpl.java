package br.edu.ifms.relacionamento.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.relacionamento.dto.ServicoRequestDto;
import br.edu.ifms.relacionamento.dto.ServicoResponseDto;
import br.edu.ifms.relacionamento.entity.Servico;
import br.edu.ifms.relacionamento.repository.ServicoRepository;
import br.edu.ifms.relacionamento.service.ServicoService;


@Service
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	@Transactional
	public ServicoResponseDto createServico(ServicoRequestDto servicoDto) {
		Servico servico = new Servico();
		servico.setServicoName(servicoDto.getServicoName());
		servico = servicoRepository.save(servico);

		ServicoResponseDto dto = new ServicoResponseDto();
		dto.setServicoName(servico.getServicoName());
		dto.setId(servico.getId());

		return dto;
	}

}
