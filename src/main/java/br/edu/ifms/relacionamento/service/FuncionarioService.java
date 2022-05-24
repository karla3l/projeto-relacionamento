package br.edu.ifms.relacionamento.service;
 import java.util.Set;


import br.edu.ifms.relacionamento.dto.FuncionarioAndProjetoRespDto;
import br.edu.ifms.relacionamento.dto.FuncionarioRequestDto;
import br.edu.ifms.relacionamento.dto.FuncionarioResponseDto;
import br.edu.ifms.relacionamento.entity.Funcionario;

public interface FuncionarioService {
	
	public FuncionarioResponseDto createFuncionario(FuncionarioRequestDto funcionarioDto);
	
	public void addProjetosToFuncionario(Integer funcionarioId, Set<Integer> projetoIds);

	public FuncionarioAndProjetoRespDto getFuncionarioDetails(Integer funcionarioId);

    public void save(Funcionario funcionario);
} 