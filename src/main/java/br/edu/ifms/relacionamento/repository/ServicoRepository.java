package br.edu.ifms.relacionamento.repository;

    
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.relacionamento.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

} 
