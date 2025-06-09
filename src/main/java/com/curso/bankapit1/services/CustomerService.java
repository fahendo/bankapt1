package com.curso.bankapit1.services;

import com.curso.bankapit1.models.Customer;
import com.curso.bankapit1.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Indicando que a classe detem os recursos de regra de negocio (RN)
@Service
public class CustomerService {

    // Injetando as dependencias necessárias
    @Autowired  // Autoinjeta uma dependencia (Cria um construtor sozinho)
    private CustomerRepo customerRepo;

    //Done: Salvar um novo cliente
    public Customer createCustomer(Customer customer){

        // Tratando possiveis erros ao gravar um novo cliente
        try {
            customerRepo.save(customer);
            System.out.println("Cliente criado com sucesso!");
        }
        catch (Exception anExcept){
            System.out.println("Erro ao criar cliente: ");
            System.out.println(anExcept);
        }
        return customer;
    }

    //Done: Buscar um cliente por ID
    public Customer findCustomerById(Integer customerId){

        //Criando elemento vazio para receber uma busca
        Customer findedCustomer = new Customer();

        //Realizando a tentativa de busca
        try {
            findedCustomer = customerRepo.findById(customerId).get();
            System.out.println(findedCustomer);
        }
        catch (Exception anExcept){
            System.out.println("Erro ao buscar cliente: ");
            System.out.println(anExcept);
        }

        return findedCustomer;

    }

    //Done: Buscar todos os clientes
    public List<Customer> findAllCustomer(){

        //Criando um array vazio
        List<Customer> customers = new ArrayList<>();

        //Populando o array com o conteudo do banco
        customerRepo.findAll().forEach(customers::add);

        //Fazendo o for no array populado para exibir os clientes em console
        customers.forEach(customer -> System.out.println(customer));

        return customers;
    }

}
