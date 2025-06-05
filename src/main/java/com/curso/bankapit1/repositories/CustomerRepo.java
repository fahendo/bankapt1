package com.curso.bankapit1.repositories;

import com.curso.bankapit1.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Indicando que a interface fara o papel de comunicacao com o banco de dados DB-DML
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {
    //NAO PRECISAMOS PROGRAMAR NADA AQUI !!!

    // Caso queira fazer um "buscar cliente por nome"
    Customer findByName(String name);

    // Caso queira fazer um "buscar cliente por CPF"
    Customer findByCpf(String cpf);
}
