/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author abekoppal
 */
@Data
@Entity
public class Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelId;
    
    @ManyToOne
    @JoinColumn(name = "MakeId")
    private Make make;
    private String model;
}
