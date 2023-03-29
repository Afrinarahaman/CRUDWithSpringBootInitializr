package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personApi")
public class PersonController {

    @Autowired
    private PersonService personService;
    @PostMapping("/savePerson")
    public ResponseEntity<String> savePerson(@RequestBody Person person)
    {
        Integer id=personService.savePerson(person);
        return new ResponseEntity<String>("Person with '"+id+"' has been saved", HttpStatus.OK);
    }

    @GetMapping("/personsList")
    public ResponseEntity<List<Person>> getAllPersons(){

        List<Person> personsList=personService.getAllPersons();
        return new ResponseEntity<List<Person>>(personsList,HttpStatus.OK);
    }
    @GetMapping("/getPersonById/{id}")
    public ResponseEntity<Person> getPersonById( @PathVariable("id") Integer id){
        Person p= personService.getPersonById(id);
        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }
    @PutMapping("/updatePerson")
    public ResponseEntity<String> updatePerson(@RequestBody Person p)
    {
        Person getPFromDb= personService.getPersonById(p.getId());
        getPFromDb.setEmail(p.getEmail());
        getPFromDb.setPassword(p.getPassword());
        Integer idP =personService.savePerson(getPFromDb);
        return new ResponseEntity<String>("Person with '"+idP+"' has been updated" , HttpStatus.OK);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") Integer id)
    {
        personService.deletePerson(id);
        return new ResponseEntity<String>("Student with '"+id+"' has been deleted ",HttpStatus.OK);
    }

}
