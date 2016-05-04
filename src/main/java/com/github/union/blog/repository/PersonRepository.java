package com.github.union.blog.repository;

import com.github.union.blog.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by union on 04.05.16.
 */

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findOnePersonById(Long id);
}
