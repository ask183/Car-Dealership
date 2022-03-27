/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.carDealership.repositories;

import com.sg.carDealership.entities.Special;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abekoppal
 */
@Repository
public interface SpecialRepository extends JpaRepository<Special, Integer> {
    @Query(value = "SELECT * FROM Special ", nativeQuery = true)
    public  List<Special> getFeaturedSpecials();
}
