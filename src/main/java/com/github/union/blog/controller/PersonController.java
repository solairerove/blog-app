package com.github.union.blog.controller;

import com.github.union.blog.domain.Person;
import com.github.union.blog.dto.PersonModel;
import com.github.union.blog.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@Valid @RequestBody PersonModel personModel) throws IOException {
        Person person = new Person(personModel.getFirstName(), personModel.getLastName());
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}