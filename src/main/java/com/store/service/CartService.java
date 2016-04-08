package com.store.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CartService {

    @PersistenceContext
    EntityManager entityManager;


}
