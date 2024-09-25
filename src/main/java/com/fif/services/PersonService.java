package com.fif.services;

import com.fif.entity.Person;

import java.util.Collection;
import java.util.List;

public interface PersonService {

    Person addPerson(Person person);

    List<Person> getPerson();
    
    void deletePerson(Integer id);

    List<Person> search(String keyword);

    void updatePerson(Person person);

    Person getById(Integer id);
}
