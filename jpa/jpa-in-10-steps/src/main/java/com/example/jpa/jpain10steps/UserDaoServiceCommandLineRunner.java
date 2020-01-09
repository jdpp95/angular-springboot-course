/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.jpain10steps;

import com.example.jpa.jpain10steps.entity.User;
import com.example.jpa.jpain10steps.service.UserDAOService;
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
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
    
    @Autowired
    private UserDAOService userDaoService;
    
    @Override
    public void run(String... args) throws Exception {
        User user = new User("User", "Admin");
        long insert = userDaoService.insert(user);
        log.info("New user has been created: " + user);
    }
}
