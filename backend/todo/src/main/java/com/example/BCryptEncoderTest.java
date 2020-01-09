/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author juan.porras
 */
public class BCryptEncoderTest {
    
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for(int i=0; i<10; i++)
        {
            String encodedString = encoder.encode("cristal1234");
            System.out.println(encodedString);
        }
    }
}
