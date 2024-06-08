package ru.kata.spring.boot_security.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.example.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
