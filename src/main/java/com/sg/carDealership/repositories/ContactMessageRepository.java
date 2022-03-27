/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.carDealership.repositories;

import com.sg.carDealership.entities.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abekoppal
 */
@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Integer> {
    
}
