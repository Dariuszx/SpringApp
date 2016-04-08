package com.store.service;


import com.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private com.store.db.User user;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        user = userRepository.getUserInfo(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));
        return userDetails;
    }

    public com.store.db.User getUser() {
        return user;
    }
}
