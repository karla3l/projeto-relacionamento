package br.edu.ifms.relacionamento.repository;

    
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.relacionamento.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

} 
