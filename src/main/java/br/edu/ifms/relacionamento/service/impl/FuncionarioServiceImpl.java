package br.edu.ifms.relacionamento.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.relacionamento.dto.FuncionarioAndProjetoRespDto;
import br.edu.ifms.relacionamento.dto.FuncionarioRequestDto;
import br.edu.ifms.relacionamento.dto.FuncionarioResponseDto;
import br.edu.ifms.relacionamento.dto.ProjetoResponseDto;
import br.edu.ifms.relacionamento.entity.Funcionario;
import br.edu.ifms.relacionamento.entity.FuncionarioProjetoMapping;
import br.edu.ifms.relacionamento.repository.FuncionarioProjetoMappingRepository;
import br.edu.ifms.relacionamento.repository.FuncionarioRepository;
import br.edu.ifms.relacionamento.repository.ProjetoRepository;
import br.edu.ifms.relacionamento.service.FuncionarioService;




@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepo;

	@Autowired
	private FuncionarioProjetoMappingRepository funcionarioProjetoMappingRepository;

	@Autowired
	private ProjetoRepository projetoRepository;

	@Override
	@Transactional
	public FuncionarioResponseDto createFuncionario(FuncionarioRequestDto funcionarioDto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setFirstName(funcionarioDto.getFirstName());
		funcionario.setLastName(funcionarioDto.getLastName());
		funcionario = funcionarioRepo.save(funcionario);

		FuncionarioResponseDto dto = new FuncionarioResponseDto();
		dto.setId(funcionario.getId());
		dto.setFirstName(funcionario.getFirstName());
		dto.setLastName(funcionario.getLastName());

		return dto;
	}

	@Override
	@Transactional
	public void addProjetosToFuncionario(Integer funcionarioId, Set<Integer> projetoIds) {
		List<FuncionarioProjetoMapping> mappings = new ArrayList<>();

		for (Integer projetoId : projetoIds) {
			FuncionarioProjetoMapping mapping = new FuncionarioProjetoMapping();

			mapping.setFuncionarioId(funcionarioId);
			mapping.setProjetoId(projetoId);

			mappings.add(mapping);
		}

		funcionarioProjetoMappingRepository.saveAll(mappings);
	}

	@Override
	public FuncionarioAndProjetoRespDto getFuncionarioDetails(Integer funcionarioId) {
		Funcionario funcionario = funcionarioRepo.findById(funcionarioId).get();
		FuncionarioAndProjetoRespDto respDto = new FuncionarioAndProjetoRespDto();
		respDto.setFirstName(funcionario.getFirstName());
		respDto.setLastName(funcionario.getLastName());
		respDto.setId(funcionario.getId());

		List<Integer> projetoIds = funcionarioProjetoMappingRepository.findAllProjetoIds(funcionarioId);

		if (projetoIds == null || projetoIds.isEmpty()) {
			return respDto;
		}

		//List<Projeto> projetos = projetoRepository.findAllById(projetoIds);
		List<br.edu.ifms.relacionamento.entity.Projeto> projetos = projetoRepository.findAllById(projetoIds);

		List<ProjetoResponseDto> projetosDto = new ArrayList<>();

		for (br.edu.ifms.relacionamento.entity.Projeto projeto : projetos) {
			ProjetoResponseDto projetoDto = new ProjetoResponseDto();
			projetoDto.setId(projeto.getId());
			projetoDto.setProjetoName(projeto.getProjetoName());

			projetosDto.add(projetoDto);
		}

		respDto.setProjetos(projetosDto);

		return respDto;
	}

	@Override
	public void save(Funcionario funcionario) {
		
		
	}

}