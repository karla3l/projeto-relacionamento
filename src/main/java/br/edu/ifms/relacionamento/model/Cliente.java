package br.edu.ifms.relacionamento.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//mandar codigo sql em txt também
//criar repository e service (receber um objeto e chamar as coisas do repositorio)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String cargo;
    private double salario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( //especifica o nome da terceira tabela
        name = "SERVICO_CLIENTE", //especifica o nome da tabela
        joinColumns = {@JoinColumn(name = "CLIENTE_ID")},
        inverseJoinColumns = {@JoinColumn(name = "SERVICO_ID")}
    )
    private List<Projeto> projetos;
    
}
