/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.entities.Purchase;
import com.sg.carDealership.service.PurchaseService;
import com.sg.carDealership.service.Result;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abekoppal
 */
@CrossOrigin
@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    
    @Autowired
    private PurchaseService service;
    
    @PostMapping
    public ResponseEntity<Object> addPurchase(@Valid @RequestBody Purchase p,  BindingResult br) {
        if (br.hasErrors()) {
            
        } 
        
        Result<Purchase> result = service.savePurchase(p);
        if (result.isSuccess()) {
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.badRequest().body(result.getMessages());
        }
    }
}