package br.edu.ifms.relacionamento.service;
 import java.util.Set;


import br.edu.ifms.relacionamento.dto.ClienteAndServicoRespDto;
import br.edu.ifms.relacionamento.dto.ClienteRequestDto;
import br.edu.ifms.relacionamento.dto.ClienteResponseDto;
import br.edu.ifms.relacionamento.entity.Cliente;

public interface ClienteService {
	
	public ClienteResponseDto createFuncionario(ClienteRequestDto clienteDto);
	
	public void addServicoToCliente(Integer clienteId, Set<Integer> servicoIds);

	public ClienteAndServicoRespDto getClienteDetails(Integer clienteId);

    public ClienteResponseDto createCliente(ClienteRequestDto clienteDto);

    public void save(Cliente cliente);
} 