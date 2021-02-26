package com.example.demo.livres.bdd;

import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre, Long> { }