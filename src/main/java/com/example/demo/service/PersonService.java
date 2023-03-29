package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;


public interface PersonService  {
    public Integer savePerson(Person Person);
    public List<Person> getAllPersons();
    public Person getPersonById(Integer id);
    public void deletePerson(Integer id);

 

}
