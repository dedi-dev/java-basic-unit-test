package com.unit.testing.repository;

import com.unit.testing.data.Person;

public interface PersonRepository {
    Person selectById(String id);
    void insert(Person person);
}
