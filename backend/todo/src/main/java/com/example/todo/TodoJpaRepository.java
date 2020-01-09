/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juan.porras
 */

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long>{
    public List<Todo> findByUsername(String username);
}
