package br.edu.ifms.relacionamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Servico {
    //criando atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private double custoTotal;
    private int duracao; //tempo em meses

    @ManyToMany(mappedBy = "servicos")
    private List<Cliente> clientes;

    public String getServicoName() {
        return null;
    }
    
}
