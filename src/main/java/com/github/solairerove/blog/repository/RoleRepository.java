package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 22.05.16.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
