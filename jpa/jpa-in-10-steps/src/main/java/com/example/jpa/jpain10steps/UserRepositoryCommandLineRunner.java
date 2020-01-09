/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.jpain10steps;

import com.example.jpa.jpain10steps.entity.User;
import com.example.jpa.jpain10steps.service.UserDAOService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author juan.porras
 */

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jill", "Admin");
        userRepository.save(user);
        log.info("New user has been created: " + user);
        
        Optional<User> userWithIdOne = userRepository.findById(1L);
        log.info("User is retrieved: " + userWithIdOne);
        
        List<User> users = userRepository.findAll();
        log.info("All users: " + users);
    }
}
