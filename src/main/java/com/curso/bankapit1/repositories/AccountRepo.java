package com.curso.bankapit1.repositories;

import com.curso.bankapit1.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepo extends CrudRepository<Account, UUID> {
    // Não precisamos programar NADA aqui !!!
    // O Spring Data JPA já implementa os métodos básicos de CRUD para nós.
}
