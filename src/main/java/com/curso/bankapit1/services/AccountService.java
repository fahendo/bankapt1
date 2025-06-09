package com.curso.bankapit1.services;

import com.curso.bankapit1.models.Account;
import com.curso.bankapit1.models.Customer;
import com.curso.bankapit1.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class AccountService {

    //Done: Injetar dependencias
    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CustomerService customerService;

    //Done: Metodo para criar uma nova conta
    public Account createAccount(Integer customerId){

        //Buscando o cliente que tera a nova conta
        Customer customer = customerService.findCustomerById(customerId);

        //Criando uma conta vazia
        Account account = new Account();
        account.setCustomer(customer);

        //Tentativa de salvar a nova conta
        try{

            accountRepo.save(account);
            System.out.println("Conta criada com sucesso!");
        }
        catch (Exception anExcept){
            System.out.println("Erro ao tentar criar a conta: ");
            System.out.println(anExcept);
        }

        return account;
    }

    //Done: Metodo para buscar uma conta por numero da conta
    //findById
    public Account findByAcNumber(UUID acNumber){

        //Criando conta vazia
        Account findedAccount = new Account();

        //Tentativa de buscar uma conta por numero
        try{
            findedAccount = accountRepo.findById(acNumber).get();
            System.out.println(findedAccount);
        }
        catch (Exception anExcept){
            System.out.println("Erro ao buscar numero de conta: ");
            System.out.println(anExcept);
        }

        return findedAccount;
    }

    //Done: Metodo para listas todas as contas
    public ArrayList<Account> listAllAccounts(){

        //Criando array vazio e populando
        ArrayList<Account> allAccounts = new ArrayList<>();
        accountRepo.findAll().forEach(allAccounts::add);

        //Mostrando as contas encontradas
        allAccounts.forEach(System.out::println);

        return allAccounts;
    }

    //Done: Metodo para mostrar o saldo de uma conta
    public Float getBalanceByAcNumber(UUID acNumber){

        Float balance = findByAcNumber(acNumber).getBalance();
        System.out.println("O saldo da conta e de: " + balance);

        return balance;
    }

    //Done: Metodo para atualizar o saldo de uma conta
    public void updateBalance(Account account, Float newBalance){

        account.setBalance(newBalance);
        accountRepo.save(account);

        System.out.println("Novo saldo e de: " + newBalance);
    }
}
