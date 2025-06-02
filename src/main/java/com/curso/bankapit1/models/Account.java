package com.curso.bankapit1.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "contas") //Indica o nome customizado para a tabela no DB - Opcional
public class Account {

    //Propriedades
    @Id @GeneratedValue(strategy = GenerationType.UUID) //Indicando a chave primaria da nossa tabela e que o ID sera gerado automaticamente pelo banco de dados
    private UUID acNumber; //Numero da conta

    @Column(name = "saldo") //Indica que a propriedade se transformara em uma coluna da nossa tabela - name Opcional
    private Float balance = 0.0f; //Saldo da conta

    @ManyToOne //Indica o relacionamento 1:N entre Conta e Cliente
    @JoinColumn(name = "customer") //Indica qual campo fara conexao como chave estrangeira
    private Customer customer; //Cliente dono da conta

    //Construtores
    public Account(Float balance, Customer customer) {
        this.balance = balance;
        this.customer = customer;
    }

    public Account() {}

    //Getters
    public UUID getAcNumber() {
        return acNumber;
    }

    public Float getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    //Setters
    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //Metodos sobrescritos
    @Override
    public String toString() {
        return "Account{" +
                "acNumber=" + acNumber +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
