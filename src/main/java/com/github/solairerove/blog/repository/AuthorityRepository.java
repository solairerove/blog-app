package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 22.05.16.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
