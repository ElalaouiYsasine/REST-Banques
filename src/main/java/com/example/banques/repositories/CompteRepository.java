package com.example.banques.repositories;

import com.example.banques.entities.Compte;
import org.springframework.data.repository.CrudRepository;

public interface CompteRepository extends CrudRepository<Compte, Long> {

}
