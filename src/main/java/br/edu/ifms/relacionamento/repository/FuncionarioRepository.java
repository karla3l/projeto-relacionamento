package br.edu.ifms.relacionamento.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.relacionamento.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}


