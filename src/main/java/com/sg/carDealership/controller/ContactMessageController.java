/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.entities.ContactMessage;
import com.sg.carDealership.service.ContactMessageService;
import com.sg.carDealership.service.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/message")
public class ContactMessageController {
    
    @Autowired
    private ContactMessageService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactMessage> addContactMessage(@RequestBody ContactMessage m) {
        Result<ContactMessage> result = service.addContactMessage(m);
        if (result.isSuccess()) {
            return ResponseEntity.ok(m);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
}
