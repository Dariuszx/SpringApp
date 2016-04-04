package com.store.repository;


import com.store.db.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User getUserInfo(String username);

}
