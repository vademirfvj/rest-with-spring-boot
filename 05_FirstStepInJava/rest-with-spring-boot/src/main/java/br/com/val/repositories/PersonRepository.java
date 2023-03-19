package br.com.val.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.val.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
