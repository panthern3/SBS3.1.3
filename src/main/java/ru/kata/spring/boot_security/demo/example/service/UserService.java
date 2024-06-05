package ru.kata.spring.boot_security.demo.example.service;

import ru.kata.spring.boot_security.demo.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User findByEmail(String email); // Новый метод
}
