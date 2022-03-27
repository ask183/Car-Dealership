/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.service;

import com.sg.carDealership.entities.ContactMessage;
import com.sg.carDealership.repositories.ContactMessageRepository;
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
public class ContactMessageService {

    @Autowired
    ContactMessageRepository repo;
    
    public Result<ContactMessage> addContactMessage(ContactMessage m) {
        Result<ContactMessage> result = validate(m);
    
        if (result.isSuccess()) {
            m = repo.save(m);
            result.setPayload(m);
        }
        return result;

    }

    
    private Result<ContactMessage> validate(ContactMessage m) {
        Result<ContactMessage> result = new Result<>();

        if (m.getEmail().length() == 0 && m.getPhone().length() == 0) {
            result.addMessage("Either a phone number or email address is required.");
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<ContactMessage>> errs = validator.validate(m);
        for (ConstraintViolation<ContactMessage> err : errs) {
            result.addMessage(err.getMessage());
        }

        return result;
    }   

}
