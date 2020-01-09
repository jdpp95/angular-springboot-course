/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author juan.porras
 */
class AuthenticationBean {
    
    private String message;

    public AuthenticationBean(String msg) {
        this.message = msg;
    }
    
    public void setMessage(String msg){
        this.message = msg;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    @Override
    public String toString(){
        return this.getMessage();
    }
}
