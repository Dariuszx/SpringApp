package com.store.repository;

import com.store.db.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public User getUserInfo(String username) {

        String sql = "SELECT u.user_id, u.username username, u.password password, a.authority role " +
                "FROM users u INNER JOIN authorities a ON u.user_id = a.user_id " +
                "WHERE u.enabled = 1 and u.username = ?";

        Query q = em.createNativeQuery(sql, User.class).setParameter(1, username);
        return (User)q.getSingleResult();
    }
}
