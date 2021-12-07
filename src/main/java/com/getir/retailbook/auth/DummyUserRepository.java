package com.getir.retailbook.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DummyUserRepository{
    private Map<String, User> users = new HashMap<>();

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void initialize() {
        users.put("admin", new User("admin", passwordEncoder.encode("admin"),new ArrayList<>()));

    }

    User findByUsername(String username){
        return users.get(username);
    }
}
