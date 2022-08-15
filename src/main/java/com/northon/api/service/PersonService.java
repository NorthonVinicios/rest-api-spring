package com.northon.api.service;

import com.northon.api.exceptions.ResourceNotFoundException;
import com.northon.api.model.Person;
import com.northon.api.repositories.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepositorie repository;

    public Person findById(Long id) {
//        Person person = new Person();
//        person.setId(counter.incrementAndGet());
//        person.setFisrtName("Northon");
//        person.setLastName("Soares");
//        person.setAdress("Campo Mourão - Parana");
//        person.setGender("Masculino");
//        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records for this id"));
    }
    public List<Person> findAll() {
        return repository.findAll();
    }



    public Person update(Person person) {
        var entity = repository.findById(person.getId()).orElseThrow(()->new ResourceNotFoundException("No records for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAdress(person.getAdress());
        return repository.save(entity);
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No records for this id"));

        repository.delete(entity);
    }
}
