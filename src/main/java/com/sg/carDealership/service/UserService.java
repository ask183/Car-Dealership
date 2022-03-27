/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.service;

import com.sg.carDealership.entities.User;
import com.sg.carDealership.repositories.UserRepository;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abekoppal
 */
@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public Result<List<User>> getAllUsers() {
        Result<List<User>> result = new Result<>();
        result.setPayload(repo.findAll());
        return result;
    }
    
    public User editUser(User u){
        User user = repo.save(u);
        return user;
    }

    public Result<User> saveUser(User u) {
        Result<User> result = validate(u);
        if (result.isSuccess()) {
            u = repo.save(u);
            result.setPayload(u);
        }
        return result;

    }
    

    private Result<User> validate(User u) {
        Result<User> result = new Result<>();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> errs = validator.validate(u);
        for (ConstraintViolation<User> err : errs) {
            result.addMessage(err.getMessage());
        }

        return result;
    }

}