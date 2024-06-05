package ru.kata.spring.boot_security.demo.example.dao;

import ru.kata.spring.boot_security.demo.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<ru.kata.spring.boot_security.demo.example.model.User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", ru.kata.spring.boot_security.demo.example.model.User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(ru.kata.spring.boot_security.demo.example.model.User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        ru.kata.spring.boot_security.demo.example.model.User user = entityManager.find(ru.kata.spring.boot_security.demo.example.model.User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(ru.kata.spring.boot_security.demo.example.model.User user) {
        entityManager.merge(user);
    }

    @Override
    public ru.kata.spring.boot_security.demo.example.model.User findByEmail(String email) {
        TypedQuery<ru.kata.spring.boot_security.demo.example.model.User> query = entityManager.createQuery
                ("SELECT u FROM User u WHERE u.email = :email", ru.kata.spring.boot_security.demo.example.model.User.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

}