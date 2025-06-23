package com.curso.bankapit1;

import com.curso.bankapit1.models.Account;
import com.curso.bankapit1.models.Customer;
import com.curso.bankapit1.services.AccountService;
import com.curso.bankapit1.services.CustomerService;
import com.curso.bankapit1.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Bankapit1Application {

	// Injetando os Services ==============================================
	private static CustomerService customerService;
	private static AccountService accountService;
	private static TransactionService transactionService;

	public Bankapit1Application(CustomerService customerService, AccountService accountService, TransactionService transactionService) {
		this.customerService = customerService;
		this.accountService = accountService;
		this.transactionService = transactionService;
	}
// Injetando o CustomerService ========================================

	public static void main(String[] args) {

		SpringApplication.run(Bankapit1Application.class, args);
		testador();
	}

	static void testador(){

		//Criando um novo cliente
		//Customer customerA = new Customer("Joaquim Jose", "000.000.000-00");
		//customerService.createCustomer(customerA);

		//Customer customerB = new Customer("Antonio Jorge", "111.111.111-11");
		//customerService.createCustomer(customerB);

		//Buscando Clientes
		//customerService.findCustomerById(1);
		//Buscando todos os clientes
		//customerService.findAllCustomer();

		//Testando contas
		//accountService.createAccount(1);

		//accountService.listAllAccounts();
		//9f00076e-5459-4332-af5d-d8f66be1b04c
		//accountService.findByAcNumber(UUID.fromString("9f00076e-5459-4332-af5d-d8f66be1b04c"));
		//accountService.getBalanceByAcNumber(UUID.fromString("9f00076e-5459-4332-af5d-d8f66be1b04c"));

		//Testando transacoes
		//transactionService.deposit(UUID.fromString("9f00076e-5459-4332-af5d-d8f66be1b04c"), 500.0f);

		//transactionService.withdraw(UUID.fromString("9f00076e-5459-4332-af5d-d8f66be1b04c"), 200.0f);

		//transactionService.listTransactionsByAccount(UUID.fromString("9f00076e-5459-4332-af5d-d8f66be1b04c"));
	}

}
