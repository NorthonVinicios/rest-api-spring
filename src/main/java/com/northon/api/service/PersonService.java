package com.northon.api.service;

import com.northon.api.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFisrtName("Northon");
        person.setLastName("Soares");
        person.setAdress("Campo Mourão - Parana");
        person.setGender("Masculino");
        logger.info("Finding one person!");
        return person;
    }
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFisrtName("Person "+ i);
        person.setLastName("");
        person.setAdress("Campo Mourão - Parana");
        person.setGender("Masculino");
        logger.info("Finding one person!");
        return person;
    }

    private Person update(Person person) {
        person.setId(counter.incrementAndGet());
        person.setFisrtName("Person "+ i);
        person.setLastName("");
        person.setAdress("Campo Mourão - Parana");
        person.setGender("Masculino");
        logger.info("Finding one person!");
        return person;
    }

    public Person create(Person person) {
        return person;
    }
}
