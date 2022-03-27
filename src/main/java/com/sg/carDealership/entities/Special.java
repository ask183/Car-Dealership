/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author abekoppal
 */
@Data
@Entity
public class Special {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialId;
    
    @Size(min=1, max=100)
    private String title;
    
    @Size(min=1, max=1000)
    private String description;
}
