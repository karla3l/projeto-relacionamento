package br.edu.ifms.relacionamento.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.relacionamento.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}