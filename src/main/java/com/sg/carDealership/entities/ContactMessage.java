/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author abekoppal
 */
@Data
@Entity
public class ContactMessage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    
    @Size(min=1, max=50)
    private String name;
    

 //   @Email
    private String email;
    
    
    private String phone;
    
    @Size(min=1, max=500)
    private String message;
    
}
