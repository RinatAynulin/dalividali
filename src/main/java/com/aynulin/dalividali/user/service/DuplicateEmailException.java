package com.aynulin.dalividali.user.service;

/**
 * Created by Aynulin on 31.01.2017.
 */
public class DuplicateEmailException extends Exception {

    public DuplicateEmailException(String message) {
        super(message);
    }
}