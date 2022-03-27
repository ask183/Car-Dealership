/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.carDealership.repositories;

import com.sg.carDealership.entities.Make;
import com.sg.carDealership.entities.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abekoppal
 */
@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {
    
    
    @Query(value = "SELECT * FROM Make WHERE Make = ?1", nativeQuery = true)
    public List<Vehicle> findMakebyMakeName(String makeName);
    
}
