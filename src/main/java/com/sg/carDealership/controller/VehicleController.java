/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.entities.Vehicle;
import com.sg.carDealership.entities.VehicleSearchCriteria;
import com.sg.carDealership.repositories.VehicleRepository;
import com.sg.carDealership.service.Result;
import com.sg.carDealership.service.VehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

/**
 *
 * @author abekoppal
 */
@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;
    
    @Autowired
    VehicleRepository vr;

    @GetMapping("/all")
    public List<Vehicle> getAllAvailableVehicles(@RequestBody VehicleSearchCriteria criteria) {
        return service.getAllAvailableVehicles(criteria).getPayload();
    }

    @GetMapping("/new")
    public List<Vehicle> getNewVehicles(@RequestBody VehicleSearchCriteria criteria) {
        return service.getNewVehicles(criteria).getPayload();
    }

    @GetMapping("/used")
    public List<Vehicle> getUsedVehicles(@RequestBody VehicleSearchCriteria criteria) {
        return service.getUsedVehicles(criteria).getPayload();
    }

    @GetMapping("/featured")
    public List<Vehicle> getFeaturedVehicles() {
        return service.getFeaturedVehicles().getPayload();
    }
    /*
    @GetMapping("/featuredVehicles")
    public String displayFeatures(Integer id, Model model){
        List<Vehicle> featuredVehicles = vr.getFeaturedVehicles();
        
        model.addAttribute("Year", featuredVehicles);
        model.addAttribute("MakeId", featuredVehicles);
        model.addAttribute("ModelId", featuredVehicles);
        model.addAttribute("SalePrice", featuredVehicles);
     //   return "Year"+"MakeId"+"ModelId" + "SalePrice";
        return "featuredVehicles";
    }*/

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable int vehicleId) {
        return service.getVehicleById(vehicleId).getPayload();
    }
    
    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody Vehicle v) {
        Result<Vehicle> result = service.saveVehicle(v);
        if (result.isSuccess()) {
            return ResponseEntity.ok(v);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(result.getMessages());
        }
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<Void> editVehicle(@PathVariable int vehicleId, @RequestBody Vehicle vehicle) {

        if (vehicle.getVehicleId() <= 0 || vehicleId <= 0 || vehicleId != vehicle.getVehicleId()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Result<Vehicle> result = service.saveVehicle(vehicle);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteVehicle(@PathVariable int vehicleId) {
        Result result = service.deleteById(vehicleId);
        if (result.isSuccess()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
