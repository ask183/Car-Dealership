/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.entities.Special;
import com.sg.carDealership.repositories.SpecialRepository;
import com.sg.carDealership.service.Result;
import com.sg.carDealership.service.SpecialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

/**
 *
 * @author abekoppal
 */
@CrossOrigin
@RestController
@RequestMapping("/special")
public class SpecialController {

    @Autowired
    private SpecialService service;

    @GetMapping("/all")
    public List<Special> getAllSpecials() {
        return service.getAllSpecials().getPayload();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecial(@PathVariable int specialId) {
        Result result = service.deleteById(specialId);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Special> addSpecial(@RequestBody Special s) {
        Result<Special> result = service.saveSpecial(s);
        if (result.isSuccess()) {
            return ResponseEntity.ok(s);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
