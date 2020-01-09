/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboot.basics.springbootin10steps;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juan.porras
 */
@RestController
public class BooksController {
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return Arrays.asList(
                new Book(1l, "A Storm of Swords", "George R.R Martin")
        );
    }
}
