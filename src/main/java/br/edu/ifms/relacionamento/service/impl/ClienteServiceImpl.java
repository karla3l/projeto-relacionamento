package br.edu.ifms.relacionamento.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.relacionamento.dto.ClienteAndServicoRespDto;
import br.edu.ifms.relacionamento.dto.ClienteRequestDto;
import br.edu.ifms.relacionamento.dto.ClienteResponseDto;
import br.edu.ifms.relacionamento.dto.ServicoResponseDto;
import br.edu.ifms.relacionamento.entity.Cliente;
import br.edu.ifms.relacionamento.repository.ClienteServicoMappingRepository;
import br.edu.ifms.relacionamento.repository.ClienteRepository;
import br.edu.ifms.relacionamento.repository.ServicoRepository;
import br.edu.ifms.relacionamento.service.ClienteService;




@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepo;

	@Autowired
    public ClienteServicoMappingRepository clienteServicoMappingRepository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	@Transactional
	public ClienteResponseDto createCliente(ClienteRequestDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setFirstName(clienteDto.getFirstName());
		cliente.setLastName(clienteDto.getLastName());
		cliente = clienteRepo.save(cliente);

		ClienteResponseDto dto = new ClienteResponseDto();
		dto.setId(cliente.getId());
		dto.setFirstName(cliente.getFirstName());
		dto.setLastName(cliente.getLastName());

		return dto;
	}

	@Override
	public ClienteAndServicoRespDto getClienteDetails(Integer clienteId) {
		Cliente cliente = clienteRepo.findById(clienteId).get();
		ClienteAndServicoRespDto respDto = new ClienteAndServicoRespDto();
		respDto.setFirstName(cliente.getFirstName());
		respDto.setLastName(cliente.getLastName());
		respDto.setId(cliente.getId());

		List<Integer> servicoIds = clienteServicoMappingRepository.findAllServicoIds(clienteId);

		if (servicoIds == null || servicoIds.isEmpty()) {
			return respDto;
		}

		//List<Servico> servicos = servicoRepository.findAllById(servicoIds);
		List<br.edu.ifms.relacionamento.entity.Servico> servicos = servicoRepository.findAllById(servicoIds);

		List<ServicoResponseDto> servicosDto = new ArrayList<>();

		for (br.edu.ifms.relacionamento.entity.Servico servico : servicos) {
			ServicoResponseDto servicoDto = new ServicoResponseDto();
			servicoDto.setId(servico.getId());
			servicoDto.setServicoName(servico.getServicoName());

			servicosDto.add(servicoDto);
		}

		respDto.setServicos(servicosDto);

		return respDto;
	}

    @Override
    public ClienteResponseDto createFuncionario(ClienteRequestDto clienteDto) {

        return null;
    }

    @Override
    public void addServicoToCliente(Integer clienteId, Set<Integer> servicoIds) {
        
        
    }

    @Override
    public void save(Cliente cliente) {
        
        
    }

}

