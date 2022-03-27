/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.service;

import com.sg.carDealership.entities.Special;
import com.sg.carDealership.repositories.SpecialRepository;
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
public class SpecialService {

    @Autowired
    SpecialRepository repo;

    public Result<List<Special>> getAllSpecials() {
        Result<List<Special>> result = new Result<>();
        result.setPayload(repo.findAll());
        return result;
    }

    public Result deleteById(int specialId) {
        repo.deleteById(specialId);
        return new Result<>();
    }

    public Result<Special> saveSpecial(Special s) {
        Result<Special> result = validate(s);
        if (result.isSuccess()) {
            s = repo.save(s);
            result.setPayload(s);
        }
        return result;
    }

    private Result<Special> validate(Special s) {
        Result<Special> result = new Result<>();

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Special>> errs = validator.validate(s);
        for (ConstraintViolation<Special> err : errs) {
            result.addMessage(err.getMessage());
        }

        return result;
    }
}
