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
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person getPersonByVariableId(@PathVariable(value = "id") Long id) {
        return personService.findOnePersonById(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPersonByParamId(@RequestParam(value = "id", required = false) Long id) {
        return personService.findOnePersonById(id);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.findAll();
    }
}
