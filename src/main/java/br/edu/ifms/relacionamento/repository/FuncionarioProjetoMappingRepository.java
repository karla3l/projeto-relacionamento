package br.edu.ifms.relacionamento.repository;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.ifms.relacionamento.entity.FuncionarioProjetoMapping;
import org.springframework.data.jpa.repository.Query;

public interface FuncionarioProjetoMappingRepository extends CrudRepository<FuncionarioProjetoMapping, Integer> {

	@Query(value = "select s.projeto_id from FUNCIONARIO_PROJETO_MAPPING s WHERE s.funcionario_id= :funcionarioId", nativeQuery = true)
	List<Integer> findAllProjetoIds(@Param("funcionarioId") Integer funcionarioId);

}