/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.service;

import com.sg.carDealership.entities.Make;
import com.sg.carDealership.repositories.MakeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abekoppal
 */
@Service
public class MakeService {

    @Autowired
    MakeRepository repo;
    
    public Result<List<Make>> getAllMakes() {
        Result<List<Make>> result = new Result<>();
        result.setPayload(repo.findAll());
        return result;
    }

    public Result<Make> saveMake(Make m) {
        Result<Make> result = validate(m);
        if (result.isSuccess()) {
            m = repo.save(m);
            result.setPayload(m);
        }
        return result;
    }

    private Result<Make> validate(Make m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
