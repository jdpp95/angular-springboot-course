/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.jpain10steps;

import com.example.jpa.jpain10steps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author juan.porras
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
