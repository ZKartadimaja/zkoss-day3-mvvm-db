package com.fif.viewModel;

import com.fif.entity.Person;
import com.fif.services.PersonService;
import com.fif.services.impl.PersonServiceImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.zkoss.util.resource.Labels.reset;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel {

    @WireVariable
    private PersonService personService = new PersonServiceImpl();
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String gender;
    private Date birthdayDate;
    private String province;
    private String city;
    private int luckyNumber;
    private String keyword;
    private List<Person> personList;
    private Person selectedPerson;


    @Command
    @NotifyChange({"username","password","fullName","gender","birthdayDate","city","province","luckyNumber"})
    public void add() {
        personService.addPerson(new Person(username,password,fullName,gender,birthdayDate,province,city,luckyNumber));
        reset();
        Executions.sendRedirect("searchMvvm.zul");
        search();
    }

    @Command
    @NotifyChange("selectedPerson")
    public void search(){
        selectedPerson = null;
        personList.clear();
        personList.addAll((personService.search(keyword)));
    }

    @Command
    public void deletePerson(@BindingParam("id") Integer id) {
        personService.deletePerson(id);
        personList.clear();
        personList.addAll(personService.getPerson());

        // Log the details of the person being deleted
        System.out.println("--------------------");
        System.out.println("Deleting the following user:");
        System.out.println("Id: " + selectedPerson.getId());
        System.out.println("Username: " + selectedPerson.getUsername());
        System.out.println("Gender: " + selectedPerson.getGender());
        System.out.println("Birthday Date: " + selectedPerson.getBirthdayDate());
        System.out.println("City: " + selectedPerson.getCity());
        System.out.println("Province: " + selectedPerson.getProvince());
        System.out.println("Lucky Number: " + selectedPerson.getLuckyNumber());
        System.out.println("--------------------");
        System.out.println("User deleted successfully.");
    }

    @Init
    public void init(){
        keyword = "";
        personList = new ListModelList<>();
//        personService.addPerson(new Person("azkaban",
//                        "aselole",
//                        "Azkaban Aselole",
//                        "Male",
//                        java.sql.Date.valueOf(LocalDate.of(2000, 8,13)),
//                        "West Java",
//                        "Bandung",
//                        10)
//        );
//        personService.addPerson(new Person("luna",
//                        "moonlight",
//                        "Luna Moonlight",
//                        "Female",
//                        java.sql.Date.valueOf(LocalDate.of(1995, 5, 22)),
//                        "Central Java",
//                        "Semarang",
//                        25)
//        );
//        personService.addPerson(
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
//        personService.addPerson(new Person(
//                        "maria",
//                        "rose",
//                        "Maria Rose",
//                        "Female",
//                        java.sql.Date.valueOf(LocalDate.of(1992,5,12)),
//                        "Bali",
//                        "Denpasar",
//                        33)
//        );
//        personService.addPerson(
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
//        personService.addPerson(
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
//        personService.addPerson(
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
//        personService.addPerson(
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
//        personService.addPerson(
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
//        personService.addPerson(
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
        personList.addAll(personService.getPerson());

    }

    @Command
    public void updateById(@BindingParam("id") String id) {
        Executions.sendRedirect("/edit.zul?id=" + id);
    }

    public void setKeyword(String keyword) {this.keyword = keyword; }

    public String getKeyword() {
        return keyword;
    }


    public List<Person> getPersonList(){
        return personList;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Person getSelectedPerson(){
        return selectedPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(int luckyNumber) {
        this.luckyNumber = luckyNumber;
    }
}
