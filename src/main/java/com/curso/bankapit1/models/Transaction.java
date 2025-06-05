package com.curso.bankapit1.models;

import jakarta.persistence.*;

@Entity @Table(name = "transacoes") //Indica o nome customizado para a tabela no DB - Opcional
public class Transaction {

    //Propriedades
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicando a chave primaria da nossa tabela e que o ID sera gerado automaticamente pelo banco de dados
    private Integer tsNumber; //Numero da transacao ou Transaction Number

    @Column(name = "quantia")
    private Float amount; //Valor da transacao

    @Column(name = "tipo_transacao")
    private TransactionType type; //Tipo da transacao (Enum)

    @ManyToOne @JoinColumn(name = "account")
    private Account account; //Conta associada a transacao

    //Construtores
    public Transaction(Float amount, TransactionType type, Account account) {
        this.amount = amount;
        this.type = type;
        this.account = account;
    }

    public Transaction() {}

    //Getters
    public Integer getTsNumber() {
        return tsNumber;
    }

    public Float getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Account getAccount() {
        return account;
    }

    //Setters
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    //Metodos sobrescritos
    @Override
    public String toString() {
        return "Transaction{" +
                "tsNumber=" + tsNumber +
                ", amount=" + amount +
                ", type=" + type +
                ", account=" + account +
                '}';
    }
}
