package com.northon.api.repositories;

import com.northon.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositorie extends JpaRepository<Person, Long> {}
