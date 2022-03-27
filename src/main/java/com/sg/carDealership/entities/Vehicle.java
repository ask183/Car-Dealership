/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author abekoppal
 */
@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    private String vin;
    
    @ManyToOne
    @JoinColumn(name = "MakeId")
    private Make make;
    
    @ManyToOne
    @JoinColumn(name = "ModelId")
    private Model model;
    
    private String color;
    private String type;
    private String bodyStyle;
    private String transmission;
    private String interior;
    
    @Digits(integer=4, fraction=0, message="Year must be 4 digits.")
    @Min(value=2000, message="Year must be between 2000 and next year.")
    private int year;
    
    
    private BigDecimal msrp;
    private BigDecimal salePrice;
    private int mileage;
    
    @Size(min=1, message="Description is required.")
    private String description;
    
    @Size(min=1, message="Photo is required.")
    private String photo;
    private boolean featured;
}
