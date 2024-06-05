package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
