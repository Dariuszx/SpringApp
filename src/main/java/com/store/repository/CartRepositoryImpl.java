package com.store.repository;


import com.store.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CartRepositoryImpl implements CartRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    AuthenticationService authenticationService;

    @Override
    public void addItemToCart(int product_id, int quantity) {
        System.out.println("działa");
    }
}
