/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juan.porras
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {
    
    @GetMapping(path = "/basicauth")
    public AuthenticationBean HelloWorldBean(){
        return new AuthenticationBean("You are authenticated.");
    }
}
