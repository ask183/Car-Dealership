/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.service;

import com.sg.carDealership.entities.Model;
import com.sg.carDealership.repositories.ModelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abekoppal
 */
@Service
public class ModelService {

    @Autowired
    ModelRepository repo;
    
    public Result<List<Model>> getAllModels() {
      Result<List<Model>> result = new Result<>();
        result.setPayload(repo.findAll());
        return result;
    }
    
    public Result<Model> saveModel(Model m) {
      Result<Model> result = validate(m);
        if (result.isSuccess()) {
            m = repo.save(m);
            result.setPayload(m);
        }
        return result;
    }

    private Result<Model> validate(Model m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
