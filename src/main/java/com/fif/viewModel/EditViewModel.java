package com.fif.viewModel;

import com.fif.entity.Person;
import com.fif.services.PersonService;
import com.fif.services.impl.PersonServiceImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Date;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class EditViewModel {
    @WireVariable
    PersonService personService = new PersonServiceImpl();
    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String gender;
    private Date birthdayDate;
    private String province;
    private String city;
    private int luckyNumber;

    @Init
    public void init() {
        this.id = Integer.valueOf(Executions.getCurrent().getParameter("id"));
        if (this.id == null) {
            Executions.sendRedirect("helloworld.zul");
            return;
        }
        Person selectedUser = personService.getById(id);
        if (selectedUser == null)
            throw new RuntimeException("Please go through from Table");

        this.setFullName(selectedUser.getFullName());
        this.setGender(selectedUser.getGender());
        this.setBirthdayDate(selectedUser.getBirthdayDate());
        this.setCity(selectedUser.getCity());
        this.setProvince(selectedUser.getProvince());
        this.setLuckyNumber(selectedUser.getLuckyNumber());
    }

    @Command
    public void updatePerson() {
        Person person = new Person();
        person.setId(id);
        person.setFullName(fullName);
        person.setGender(gender);
        person.setBirthdayDate(birthdayDate);
        person.setCity(city);
        person.setProvince(province);
        person.setLuckyNumber(luckyNumber);
        personService.updatePerson(person);
        Executions.sendRedirect("searchMvvm.zul");
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
