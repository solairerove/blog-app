package com.github.union.blog.service.impl;

import com.github.union.blog.domain.Person;
import com.github.union.blog.repository.PersonRepository;
import com.github.union.blog.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by union on 04.05.16.
 */

@Service
public class PersonServiceImpl implements PersonService {
    private Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findOnePersonById(Long id) {
        log.info("Find one person by id: " + id);
        return personRepository.findOnePersonById(id);
    }

    @Override
    public List<Person> findAll() {
        log.info("Find all persons: " );
        return personRepository.findAll();
    }

    @Override
    public void save(Person person) {
        log.info("Save entity: " + person.toString());
        personRepository.save(person);
    }

    @Override
    public boolean personExists(Long id){
        log.info("Checking person "+ id +" in database");
        return personRepository.exists(id);

    }
}