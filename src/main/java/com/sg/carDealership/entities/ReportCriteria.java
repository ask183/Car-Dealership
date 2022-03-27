/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.entities;

import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author abekoppal
 */
@Data
public class ReportCriteria {
    
    private User user;
    private LocalDate minDate;
    private LocalDate maxDate;
}
