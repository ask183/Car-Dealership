/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.entities.Make;
import com.sg.carDealership.service.MakeService;
import com.sg.carDealership.service.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abekoppal
 */
@CrossOrigin
@RestController
@RequestMapping("/make")
public class MakeController {

    @Autowired
    private MakeService service;

     @GetMapping("/all")
    public List<Make> getAllMakes() {
        return service.getAllMakes().getPayload();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Make> addMake(@RequestBody Make m) {
        Result<Make> result = service.saveMake(m);
        if (result.isSuccess()) {
            return ResponseEntity.ok(m);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}