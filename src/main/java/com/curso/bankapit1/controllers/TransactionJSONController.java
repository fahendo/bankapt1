package com.curso.bankapit1.controllers;

import com.curso.bankapit1.models.Transaction;
import com.curso.bankapit1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/json/transactions") //Raiz de Transactions
public class TransactionJSONController {

    //Done: Injecao de dependencias
    @Autowired
    TransactionService transactionService;

    //Done: Endpoint GET para listar todas as transacoes em uma conta
    //Endpoint: http://localhost:8080/json/transactions/umAcNum
    //9f00076e-5459-4332-af5d-d8f66be1b04c
    @GetMapping("/{acNumber}")
    public ArrayList<Transaction> listAllTransactionsByAcNumber(@PathVariable UUID acNumber){
        return transactionService.listTransactionsByAccount(acNumber);
    }

    //Todo: Endpoint POST para gerar um Deposito
    //Endpoint: http://localhost:8080/json/transactions/deposit/{acNumber}/{amount}
    //9f00076e-5459-4332-af5d-d8f66be1b04c/135.00
    /*@PostMapping("/deposit/{acNumber}/{amount}")
    public Transaction deposit(){

    }
    */

    //Todo: Endpoint POST para gerar um Saque
}
