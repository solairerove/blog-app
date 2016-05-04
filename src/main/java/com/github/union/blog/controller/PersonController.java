package com.github.union.blog.controller;

import com.github.union.blog.domain.Person;
import com.github.union.blog.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by union on 04.05.16.
 */

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Person getPersonByVariableId(@PathVariable(value = "id") Long id) {
        return personService.findOnePersonById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Person getPersonByParamId(@RequestParam(value = "id", required = false) Long id) {
        return personService.findOnePersonById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

//    @RequestMapping(value = "/add/{firstName}/{lastName}", method = RequestMethod.POST)
//    public void addPerson(@PathVariable String firstName, @PathVariable String lastName) {
//        personService.save(new Person(firstName, lastName));
//    }
}