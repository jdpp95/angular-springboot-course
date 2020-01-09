/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author juan.porras
 */
@Service
class HardCodedService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static long idCounter = 0;
    
    static {
        todos.add(new Todo(++idCounter, "jdpp95", "Arrive to Yopal", new Date(), false));
        todos.add(new Todo(++idCounter, "jdpp95", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "jdpp95", "Make DinnerQR", new Date(), true));
    }
    
    public List<Todo> findAll(){
        return todos;
    }
    
    public Todo deleteById(long id){
        Todo todo = findById(id);
        if (todo == null) return null;
        if(todos.remove(todo)){
            return todo;
        }
        
        return null;
    }
    
    public Todo findById(long id){
        for(Todo todo : todos)
        {
            if(todo.getId() == id) {
                return todo;
            }
        }
        
        return null;
    }
    
    public Todo save(Todo todo){
        if(todo.getId() == -1 || todo.getId() == 0)
        {
            todo.setId(++idCounter);
        } else {
            deleteById(todo.getId());
        }
        todos.add(todo);
        return todo;
    }
    
}
