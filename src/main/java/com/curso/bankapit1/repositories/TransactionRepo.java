package com.curso.bankapit1.repositories;

import com.curso.bankapit1.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Integer> {

    //Criando um metodo com uma query customizada baseado em uma estrategia
    List<Transaction> findByAccountAcNumber(UUID acNumber);

    // DEIXANDO DICA PARA PESQUISA: Pesquisar por JPQL.
    // Linguagem intermediaria entre SQL e Java
}
