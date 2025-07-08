package com.curso.bankapit1.controllers;

import com.curso.bankapit1.models.Customer;
import com.curso.bankapit1.services.CustomerService;
import com.curso.bankapit1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//Indica classe capaz de produzir endpoints JSON
@RestController

//Indica um complemento na URL para acessar os end-points JSON - Raiz de customers
@RequestMapping("/json/customers")
public class CustomerJSONController {

    //Done: Injetar as depencencias
    @Autowired
    private CustomerService customerService;

    //Done: Endpoint GET para listar todos os clientes
    //Endpoint raiz http://localhost:8080/json/customers
    @GetMapping // Raiz
    public ArrayList<Customer> listAllCustomers(){
        return customerService.findAllCustomers();
    }

    //Done: Endpoint GET para captar um cliente por ID
    //Endpoint http://localhost:8080/json/customers/{id}
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.findCustomerById(id);
    }

    //Done: Endpoint POST para criar um novo cliente
    //Endpoint http://localhost:8080/json/customers/create
    //Body: {"name": "Nome Completo", "cpf": "000.000.000-00"}
    @PostMapping("/create")
    //A Classe ResponseEntity e responsavel pelo trato de Status HTTP
    //A Annotation @RequestBody fara a solicitacao de um corpo JSON a ser passado como parametro
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

        customerService.createCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
