package ru.kata.spring.boot_security.demo.example.dao;

import ru.kata.spring.boot_security.demo.example.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);
    User findByEmail(String email);

}