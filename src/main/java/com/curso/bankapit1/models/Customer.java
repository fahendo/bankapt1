package com.curso.bankapit1.models;

import jakarta.persistence.*;

@Entity //Indica que uma Classe se transformara em uma ENtidade no DB (Banco de Dados)
@Table(name = "clientes") //Indica o nome customizado para a tabela no DB - Opcional
public class Customer {

    //Propriedades
    @Id // Indicando a chave primaria da nossa tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicando que o ID sera gerado automaticamente pelo banco de dados
    private Integer id;

    //Indica que a propriedade se transformara em uma coluna da nossa tabela - name Opcional
    @Column(name = "nome")
    private String name;

    @Column
    private String cpf;

    //Construtores   (Alt + Insert) -> Constructor
    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Customer() {} //Para Spring o construtor padrao e IMPRESCINDIVEL

    //Getters        (Alt + Insert) -> Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    //Setters        (Alt + Insert) -> Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Metodos sobrescritos
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
