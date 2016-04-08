package com.store.repository;


import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {

    void addItemToCart(int product_id, int quantity);

}
