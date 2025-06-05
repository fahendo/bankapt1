package com.curso.bankapit1.models;

// JavaClass Record -> Tem o objetivo de simplificar a criacao de classes
// que servem apenas para transportar dados (DTO - Data Transfer Object)
// de forma rapidamente, sem a necessidade de criar Getters, Setters.
import java.util.UUID;

public record OperationDTO(UUID acNumber, Float amount) {
}
