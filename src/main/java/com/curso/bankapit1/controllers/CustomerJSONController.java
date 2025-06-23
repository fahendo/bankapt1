package com.curso.bankapit1.controllers;

import com.curso.bankapit1.models.Customer;
import com.curso.bankapit1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//Indica classe capaz de produzir endpoints JSON
@RestController

//Indica um complemento na URL para acessar os end-points JSON - Raiz de customers
@RequestMapping("/json/customers")
public class CustomerJSONController {

    //Todo: Injetar as depencencias
    @Autowired
    private CustomerService customerService;

    //Todo: Endpoint GET para listar todos os clientes
    //Endpoint raiz http://localhost:8080/json/customers
    @GetMapping // Raiz
    public ArrayList<Customer> listAllCustomers(){
        return customerService.findAllCustomers();
    }

    //Todo: Endpoint GET para captar um cliente por ID

    //Todo: Endpoint POST para criar um novo cliente
}
