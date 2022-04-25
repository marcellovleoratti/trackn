package com.example.trackn.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="funcionarios")
@Getter
@Setter
@Data
@EqualsAndHashCode
@ToString
public class Model {

    public Model(){}

    public Model(String nome, Integer idade,  String  cep, String sexo, String endereco, String bairro, String cidade, String estado){
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
        this.sexo = sexo;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @NotNull
    private String cep;

    private String sexo;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;

}
