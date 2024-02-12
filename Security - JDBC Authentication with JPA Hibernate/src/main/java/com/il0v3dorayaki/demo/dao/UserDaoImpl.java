package com.il0v3dorayaki.demo.dao;

import com.il0v3dorayaki.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String username) {

        // retrieve/read from database using username
        TypedQuery<User> theQuery = entityManager.createQuery(
                "from User where userName=:uName and enabled=true", User.class);
        theQuery.setParameter("uName", username);

        User user = null;
        try {
            user = theQuery.getSingleResult();
        } catch (Exception ignored) {
        }

        return user;
    }
}
