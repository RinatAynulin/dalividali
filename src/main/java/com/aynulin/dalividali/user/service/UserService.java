package com.aynulin.dalividali.user.service;

import com.aynulin.dalividali.security.dto.RegistrationForm;
import com.aynulin.dalividali.user.model.User;

/**
 * Created by Aynulin on 31.01.2017.
 */
public interface UserService {

    /**
     * Creates a new user account to the service.
     * @param userAccountData   The information of the created user account.
     * @return  The information of the created user account.
     * @throws DuplicateEmailException Thrown when the email address is found from the database.
     */
    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;

    public User getUserByEmail(String email);
}