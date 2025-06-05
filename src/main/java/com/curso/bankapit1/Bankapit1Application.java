package com.curso.bankapit1;

import com.curso.bankapit1.models.Customer;
import com.curso.bankapit1.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bankapit1Application {

	// Injetando o CustomerService ========================================
	private static CustomerService customerService;

	public Bankapit1Application(CustomerService customerService) {
		this.customerService = customerService;
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

		//Customer customerB = new Customer("ANtonio Jorge", "111.111.111-11");
		//customerService.createCustomer(customerB);

		//Buscando Clientes
		//customerService.findCustomerById(1);

		//Buscando todos os clientes
		customerService.findAllCustomer();

	}

}
