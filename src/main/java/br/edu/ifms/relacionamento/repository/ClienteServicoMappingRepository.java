package br.edu.ifms.relacionamento.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.relacionamento.entity.ClienteServicoMapping;
import org.springframework.data.jpa.repository.Query;

public interface ClienteServicoMappingRepository extends CrudRepository<ClienteServicoMapping, Integer> {

	@Query(value = "select s.servico_id from CLIENTE_SERVICO_MAPPING s WHERE s.cliente_id= :clienteId", nativeQuery = true)
	List<Integer> findAllServicoIds(@Param("clienteId") Integer clienteId);

    @Transactional
    default void addServicosToCliente(Integer clienteId, Set<Integer> servicoIds) {
    	List<ClienteServicoMapping> mappings = new ArrayList<>();
    
    	for (Integer servicoId : servicoIds) {
    		ClienteServicoMapping mapping = new ClienteServicoMapping();
    
    		mapping.setClienteId(clienteId);
    		mapping.setServicoId(servicoId);
    
    		mappings.add(mapping);
    	}
    
    	saveAll(mappings);
    }

}
    

