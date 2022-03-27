/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.entities;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author abekoppal
 */
@Data
public class VehicleSearchCriteria {

    
    private String makeModelYear;
    private Integer minYear;
    private Integer maxYear;
    private BigDecimal minSalePrice;
    private BigDecimal maxSalePrice;
    
}
