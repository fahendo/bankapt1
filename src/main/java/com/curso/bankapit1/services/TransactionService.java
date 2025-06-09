package com.curso.bankapit1.services;

import com.curso.bankapit1.models.Account;
import com.curso.bankapit1.models.Transaction;
import com.curso.bankapit1.models.TransactionType;
import com.curso.bankapit1.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    //Done: Injecao das dependencias
    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private AccountService accountService;

    //Done: Metodo para gerar depositos
    public Transaction deposit(UUID acNumber, Float amount){

        //Indicando a conta a ser utilizada
        Account account = accountService.findByAcNumber(acNumber);

        //Criando novo saldo
        Float newBalance = account.getBalance() + amount;

        //Criando a transacao
        Transaction transaction = new Transaction(amount, TransactionType.DEPOSIT, account);

        //Tentativa de salvar a transacao
        try{
            //Atualizando saldo
            accountService.updateBalance(account, newBalance);
            transactionRepo.save(transaction);
            System.out.println("Deposito efetuado com sucesso!");
        }
        catch (Exception anExcept){
            System.out.println(anExcept);
        }

        return transaction;
    }

    //Done: Metodo para gerar saques
    public Transaction withdraw(UUID acNumber, Float amount){

        //Indicando a conta a ser utilizada
        Account account = accountService.findByAcNumber(acNumber);

        //Criando novo saldo
        Float newBalance = account.getBalance() - amount;

        //Criando a transacao
        Transaction transaction = new Transaction(amount, TransactionType.WITHDRAWAL, account);

        //Tentativa de salvar a transacao
        try{

            //Verificando se existe saldo na conta
            if(account.getBalance().compareTo(amount) < 0){
                throw new RuntimeException("Saldo insuficiente.");
            }
            else {
                //Atualizando saldo
                accountService.updateBalance(account, newBalance);
                transactionRepo.save(transaction);
                System.out.println("Saque efetuado com sucesso!");
            }
        }
        catch (Exception anExcept){
            System.out.println(anExcept);
        }

        return transaction;
    }

    //Done: Metodo para listar todas as transacoes
    public ArrayList<Transaction> listTransactionsByAccount(UUID acNumber){

        //Criando lista vazia
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        transactionRepo.findByAccountAcNumber(acNumber).forEach(allTransactions::add);

        //Exibindo transacoes
        allTransactions.forEach(transaction -> System.out.println(transaction));

        return allTransactions;
    }

}
