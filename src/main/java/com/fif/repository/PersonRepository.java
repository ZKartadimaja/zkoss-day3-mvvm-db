package com.fif.repository;

import com.fif.entity.Log;
import com.fif.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Person> queryAll() {
        Query query = em.createQuery("SELECT p FROM Person p");
        List<Person> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public Person get(Integer id) {
        return em.find(Person.class, id);
    }

    @Transactional
    public Person save(Person person) {
        em.persist(person);
        em.flush();
        return person;
    }

    @Transactional
    public Person delete(Integer id) {
        Person selectedPerson = get(id);
        if (selectedPerson != null) {
            em.remove(selectedPerson);
        }
        return selectedPerson;
    }

    @Transactional(readOnly = true)
    public List<Person> search(String keyword) {
        Query query = em.createQuery("SELECT p FROM Person p WHERE" +
                " LOWER(p.fullName) LIKE LOWER(:kName) or LOWER(p.gender) = LOWER(:kGender)");
        query.setParameter("kName", "%" + keyword + "%");
        query.setParameter("kGender", keyword);
        List<Person> result = query.getResultList();
        return result;
    }

    @Transactional
    public Person editPerson(Person person) {
        System.out.println(person.getId());
        Person selectedPerson = get(person.getId());
        if (selectedPerson != null) {
            selectedPerson.setFullName(person.getFullName());
            selectedPerson.setGender(person.getGender());
            selectedPerson.setBirthdayDate(person.getBirthdayDate());
            selectedPerson.setCity(person.getCity());
            selectedPerson.setProvince(person.getProvince());
            selectedPerson.setLuckyNumber(person.getLuckyNumber());
        }
        return selectedPerson;
    }
}

//    static {
//        personList.add(
//                new Person(
//                        "azkaban",
//                        "aselole",
//                        "Azkaban Aselole",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(2000, 8,13)),
//                        "West Java",
//                        "Bandung",
//                        10)
//        );
//        personList.add(
//                new Person(
//                        "luna",
//                        "moonlight",
//                        "Luna Moonlight",
//                        "Female",
//                        java.sql.Date.valueOf(LocalDate.of(1995, 5, 22)),
//                        "Central Java",
//                        "Semarang",
//                        25));
//        personList.add(
//                new Person(
//                        "thor",
//                        "hammer",
//                        "Thor Hammer",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(1988,8,15)),
//                        "East Java",
//                        "Surabaya",
//                        42)
//        );
//        personList.add(
//                new Person(
//                        "maria",
//                        "rose",
//                        "Maria Rose",
//                        "Female",
//                        java.sql.Date.valueOf(LocalDate.of(1992,5,12)),
//                        "Bali",
//                        "Denpasar",
//                        33)
//        );
//        personList.add(
//                new Person(
//                        "gandalf",
//                        "wizard",
//                        "Gandalf The Wizard",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(1980,1,1)),
//                        "West Nusa Tenggara",
//                        "Mataram",
//                        5)
//        );
//        personList.add(
//                new Person(
//                        "hermione",
//                        "granger",
//                        "Hermione Granger",
//                        "Female",
//                        java.sql.Date.valueOf(LocalDate.of(1996,9,19)),
//                        "Jakarta",
//                        "Jakarta",
//                        8)
//        );
//
//        personList.add(
//                new Person(
//                        "sauron",
//                        "darklord",
//                        "Sauron the Dark Lord",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(1990,10,30)),
//                        "Yogyakarta",
//                        "Yogyakarta",
//                        18)
//        );
//
//        personList.add(
//                new Person(
//                        "neville",
//                        "longbottom",
//                        "Neville Longbottom",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(1997,7,17)),
//                        "Banten",
//                        "Serang",
//                        3)
//        );
//
//        personList.add(
//                new Person(
//                        "daenerys",
//                        "targaryen",
//                        "Daenerys Targaryen",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(1985,3,26)),
//                        "Sumatra",
//                        "Medan",
//                        99)
//        );
//        personList.add(
//                new Person(
//                        "frodo",
//                        "baggins",
//                        "Frodo Baggins",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(1994,9,22)),
//                        "Aceh",
//                        "Banda Aceh",
//                        21)
//        );
//    }
