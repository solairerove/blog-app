package com.github.union.blog.service;

import com.github.union.blog.domain.Person;

import java.util.List;

/**
 * Created by union on 04.05.16.
 */

public interface PersonService {
    Person findOnePersonById(Long id);

    List<Person> findAll();

    void save(Person person);

    boolean personExists(Long id);
}