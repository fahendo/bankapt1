package com.curso.bankapit1.controllers;

import com.curso.bankapit1.models.Account;
import com.curso.bankapit1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/json/accounts") //Raiz de Accounts
public class AccountJSONController {

    //Todo: Injecao de dependencias
    @Autowired
    private AccountService accountService;

    //Todo: Endpoint GET para listar todas as contas
    //Endpoint raiz http://localhost:8080/json/accounts
    @GetMapping // Raiz
    public ArrayList<Account> listAllAccounts(){
        return accountService.listAllAccounts();
    }

    //Done: Endpoint GET para captar uma conta por numDeConta
    //Endpoint raiz http://localhost:8080/json/accounts/{numDeConta}
    //9f00076e-5459-4332-af5d-d8f66be1b04c
    @GetMapping("/{acNumber}")
    public Account getAccountByAcNumber(@PathVariable UUID acNumber){
        return accountService.findByAcNumber(acNumber);
    }

    //Done: Endpoint GET para captar o balanco de uma conta por numDeConta
    @GetMapping("/{acNumber}/balance")
    //Endpoint http://localhost:8080/json/accounts/acNumber/balance
    //9f00076e-5459-4332-af5d-d8f66be1b04c
    public Float getBalanceByAcNumber(@PathVariable UUID acNumber){
        return accountService.getBalanceByAcNumber(acNumber);
    }

    //Todo: Endpoint POST para criar uma nova conta
    //Endpoint http://localhost:8080/json/accounts/create/idCustomer
    @PostMapping("/create/{customerId}")
    public ResponseEntity<Account> createAccount(@PathVariable Integer customerId){

        Account account = accountService.createAccount(customerId);

        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }
}
