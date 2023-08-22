package com.unit.testing.service;

import java.util.UUID;

import com.unit.testing.data.Person;
import com.unit.testing.repository.PersonRepository;

public class PersonService {
    
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(String id) {
        Person person = personRepository.selectById(id);
        if (person != null) {
            return person;
        } else {
            throw new IllegalArgumentException("Data Person not found");
        }
    }

    public Person register(String name) {
        Person person = new Person(UUID.randomUUID().toString(), name);
        personRepository.insert(person);
        return person;
    }
}
