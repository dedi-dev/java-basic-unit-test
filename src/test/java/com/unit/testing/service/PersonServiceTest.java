package com.unit.testing.service;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unit.testing.data.Person;
import com.unit.testing.repository.PersonRepository;

@Extensions({
    @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {
    
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }


    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("2");
        });
    }

    @Test
    void testGetPersonSuccess() {
        Mockito.when(personRepository.selectById("1")).thenReturn(new Person("1", "Dedi"));
        Person person = personService.get("1");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Dedi", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        Person person = personService.register("Dedi");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Dedi", person.getName());
        
        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(person.getId(), "Dedi"));
    }
}
