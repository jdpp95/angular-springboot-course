/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.jpain10steps.service;

import com.example.jpa.jpain10steps.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juan.porras
 */

@Repository
@Transactional
public class UserDAOService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public long insert(User user)
    {
        //Open Transaction
        entityManager.persist(user);
        return user.getId();
    }
}
