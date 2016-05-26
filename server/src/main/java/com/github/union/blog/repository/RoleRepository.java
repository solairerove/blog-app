package com.github.union.blog.repository;

import com.github.union.blog.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vlad on 22.05.16.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
