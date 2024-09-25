package com.fif.services.impl;

import com.fif.entity.Person;
import com.fif.repository.PersonRepository;
import com.fif.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getPerson() {
        return personRepository.queryAll();
    }

    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }

    public List<Person> search(String keyword){
        return personRepository.search(keyword);
    }

    public Person getById(Integer id) {
        return personRepository.get(id);
    }

    public void updatePerson(Person person){
        personRepository.editPerson(person);
    }

    //Data Model
//    private List<Person> personList = PersonRepository.personList;
//    private PersonRepository repository = new PersonRepository();
    //    private static int id = 1;

//    public PersonServiceImpl() {
//        personList = repository.findAll();
//    }

//    public void findAll() {
//        ;
//    }

//    public List<Person> search(String keyword) {
//        List<Person> result = new LinkedList<Person>();
//        if (keyword == null || keyword.isEmpty()) {
//            result = personList;
//        } else {
//            for (Person p : personList) {
//                if (p.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
//                    result.add(p);
//                }
//                else if (p.getGender().equalsIgnoreCase(keyword)) {
//                    result.add(p);
//                }
//                else if (p.getBirthdayDate().equals(keyword)) {
//                    result.add(p);
//                }
//            }
//        }
//        return result;
//    }

//    @Override
//    public void deletePerson(Integer id){
//        personRepository.delete(person -> Objects.equals(person.getId(), id));
//    }
//    @Override
//    public void add(Integer id, String username, String password, String fullName, String gender, Date birthdayDate, String province, String city, int luckyNumber) {
//        personRepository.save(new Person( username, password, fullName, gender, birthdayDate, province, city, luckyNumber));
//    }
//

//
//    @Override
//    public void saveUser(Person user) {
//        personRepository.save(user);
//        return;
//    }
//    @Override
//    public void updateUser(Person user) {
//        this.deletePerson(user.getId());
//        this.saveUser(user);
//        return;
//    }
}


