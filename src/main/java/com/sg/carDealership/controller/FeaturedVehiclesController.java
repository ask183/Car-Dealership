/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.carDealership.controller;

import com.sg.carDealership.entities.ContactMessage;
import com.sg.carDealership.entities.Purchase;
import com.sg.carDealership.entities.Special;
import com.sg.carDealership.entities.User;
import com.sg.carDealership.entities.Vehicle;
import com.sg.carDealership.entities.VehicleSearchCriteria;
import com.sg.carDealership.repositories.SpecialRepository;
import com.sg.carDealership.repositories.UserRepository;
import com.sg.carDealership.repositories.VehicleRepository;
import com.sg.carDealership.service.ContactMessageService;
import com.sg.carDealership.service.PurchaseService;
import com.sg.carDealership.service.Result;
import com.sg.carDealership.service.UserService;
import com.sg.carDealership.service.VehicleService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author abekoppal
 */
@Controller
public class FeaturedVehiclesController {
    
    @Autowired
    VehicleRepository vr;
    
    @Autowired
    SpecialRepository special;
    
    @Autowired
    VehicleService serv;
    
    @Autowired
    ContactMessageService cms;
    
    @Autowired
    PurchaseService ps;
    
    @Autowired
    UserRepository ur;
    
    @Autowired
    UserService us;
    
    @GetMapping("/")
    public String displayHomePage(Integer id, Model model){
        List<Vehicle> featuredVehicles = vr.getFeaturedVehicles();
        List<Special> featuredSpecials = special.getFeaturedSpecials();
        
        model.addAttribute("featuredSpecials", featuredSpecials);
        model.addAttribute("featuredVehicles", featuredVehicles);
     
        return "features";
    }
    
    @GetMapping("/featuredVehicles")
    public String displayFeatures(Integer id, Model model){
        List<Vehicle> featuredVehicles = vr.getFeaturedVehicles();
        List<Special> featuredSpecials = special.getFeaturedSpecials();
        
        model.addAttribute("featuredSpecials", featuredSpecials);
        model.addAttribute("featuredVehicles", featuredVehicles);
     
        return "features";
    }
    
    @GetMapping("/newcar")
    public String displayNewCars(Integer id, Model model){
        VehicleSearchCriteria crit = new VehicleSearchCriteria();
        crit.setMakeModelYear("");
        crit.setMinYear(0);
        crit.setMaxYear(3000);
        crit.setMinSalePrice(BigDecimal.ZERO);
        crit.setMaxSalePrice(new BigDecimal("10000000"));
        
       
        Result<List<Vehicle>> newcar = serv.getNewVehicles(crit);
        
        model.addAttribute("newcar", newcar.getPayload());   
        
        return "newcar";
    }
    
    @GetMapping("/newCarSpecificSearch")
    public String displayNewCarSpecificSearch(VehicleSearchCriteria crit, Model model){
        Result<List<Vehicle>> newCarSpecificSearch = serv.getNewVehicles(crit);
        model.addAttribute("newCarSpecificSearch", newCarSpecificSearch.getPayload()); 
        return "newcar";
    }
    
    @PostMapping("/newCarSpecificSearch")
    public String sendSpecificCarSearch(VehicleSearchCriteria m){
     /*   if (m.getMaxSalePrice().equals(new BigDecimal("102000"))){
            return "newcar";
        }
        if (m.getMinSalePrice().equals(new BigDecimal("100"))){
            return "newcar";
        }*/
        Result<List<Vehicle>> newCarSpecificSearch = serv.getNewVehicles(m);
        if (newCarSpecificSearch.isSuccess()) {
            return "redirect:/newCarSpecificSearch";
        } else {
            return "redirect:/newcar";
        }
    } 
    
    @GetMapping("/usedcar")
    public String displayUsedCars(Integer id, Model model){
        VehicleSearchCriteria crit = new VehicleSearchCriteria();
        crit.setMakeModelYear("");
        crit.setMinYear(0);
        crit.setMaxYear(3000);
        crit.setMinSalePrice(BigDecimal.ZERO);
        crit.setMaxSalePrice(new BigDecimal("10000000"));
        
        Result<List<Vehicle>> usedcar = serv.getUsedVehicles(crit);
        
        model.addAttribute("usedcar", usedcar.getPayload());   
        
        return "usedcar";
    }
    
    @GetMapping("/carDetails")
    public String displayCarDetails(Integer id, Model model){
        
        
        Result<Vehicle> carDetails = serv.getVehicleById(id);
        model.addAttribute("Vehicle", carDetails.getPayload());
        
        return "detail";
        
        
    }
    
    @GetMapping("/adminPage")
    public String displayAdminPage(Integer id, Model model){
        VehicleSearchCriteria crit = new VehicleSearchCriteria();
        crit.setMakeModelYear("");
        crit.setMinYear(0);
        crit.setMaxYear(3000);
        crit.setMinSalePrice(BigDecimal.ZERO);
        crit.setMaxSalePrice(new BigDecimal("10000000"));
        
        Result<List<Vehicle>> adminPage = serv.getAllAvailableVehicles(crit);
        
        model.addAttribute("adminPage", adminPage.getPayload());   
        
        return "admin";
    }
    /*
    @GetMapping("/purchaseVehicleSale")
    public String displayPurchaseVehicleSales(Purchase p, Model model){
        
        Result<Purchase> purchaseVehicleSale = ps.savePurchase(p);
        model.addAttribute("Purchase", purchaseVehicleSale.getPayload());
        return "purchase";
    }*/
    
    @GetMapping("/dealerSpecials")
    public String displaySpecials(Integer id, Model model){
        List<Special> dealerSpecials = special.getFeaturedSpecials();
        model.addAttribute("dealerSpecials", dealerSpecials);
        return "special";
    }
    
    @PostMapping("/contactMessager")
    public String sendContactMessage(ContactMessage m){
        
        Result<ContactMessage> result = cms.addContactMessage(m);
        if (result.isSuccess()) {
            return "redirect:/contactMessager";
        } else {
            return "redirect:/features";
        }
    } 
    /*
    @PostMapping("/savePurchaseForCustomer")
    public String sendPurchaseMessage(Purchase p){
        Result<Purchase> result = ps.savePurchase(p);
        if(result.isSuccess()){
            return "redirect:/"
        }
    }
    */
    @GetMapping("/contactMessager")
    public String showContactMessage(Integer id, Model model){
        return "contact";
    }
    
    @GetMapping("/salePage")
    public String displaySalesPage(Integer id, Model model){
        VehicleSearchCriteria crit = new VehicleSearchCriteria();
        crit.setMakeModelYear("");
        crit.setMinYear(0);
        crit.setMaxYear(3000);
        crit.setMinSalePrice(BigDecimal.ZERO);
        crit.setMaxSalePrice(new BigDecimal("10000000"));
        
       
        Result<List<Vehicle>> salePage = serv.getAllAvailableVehicles(crit);
        
        model.addAttribute("salePage", salePage.getPayload());   
        
        return "sales";
    }
    
    @GetMapping("/purchaseVehicleSale")
    public String displayPurchaseVehicleSales(Integer id, Model model){
        
        Result<Vehicle> purchaseVehicleSale = serv.getVehicleById(id);
        model.addAttribute("Vehicle", purchaseVehicleSale.getPayload());
        
        return "purchase";
    }
    
    @GetMapping("/adminAddANewVehicle")
    public String showAddVehicleForAdmin(Integer id, Model model){

        return "adminAddVehicle";
    }
    
    @PostMapping("/adminAddANewVehicle")
    public String sendAddVehicleForAdmin(Vehicle m){
        
        Result<Vehicle> result = serv.saveVehicle(m);
        if (result.isSuccess()) {
            return "redirect:/adminPage";
        } else {
            return "redirect:/adminAddANewVehicle";
        }
    } 
    
    @GetMapping("/adminEditAVehicle")
    public String showEditVehicleForAdmin(Integer id, Model model){
     //   List<ContactMessage> contactMessager = cms;
       // model.addAttribute("contactMessager", contactMessager);
        return "adminEditVehicle";
    }
    
    @GetMapping("/adminManageUsers")
    public String displayAdminManageUsers(Integer id, Model model){
        List<User> adminManageUsers = ur.getCarDealershipUsers();
        model.addAttribute("adminManageUsers", adminManageUsers);
        return "adminManageUsers";
    }
    
    @GetMapping("/adminAddAUser")
    public String showAddUserForAdmin(Integer id, Model model){
     //   List<ContactMessage> contactMessager = cms;
       // model.addAttribute("contactMessager", contactMessager);
        return "adminAddUser";
    }
    
    @GetMapping("/adminEditAUser")
    public String showEditUserForAdmin(Integer id, Model model){
        return "adminEditUser";
    }
    
    @PostMapping("/adminAddAUser")
    public String sendAddUserForAdmin(User m){
        Result<User> result = us.saveUser(m);
        if (result.isSuccess()) {
            return "redirect:/adminManageUsers";
        } else {
            return "redirect:/adminAddAUser";
        }
    } 
    
    @PostMapping("/adminEditAUser/{userId}")
    public String sendEditUserForAdmin(@RequestBody User m, @PathVariable Integer userId){
        if (userId == m.getUserId()){
            us.editUser(m);
            return "redirect:/adminManageUsers";
        }/*else {
            return "redirect:/adminEditAUser";
        }*/
        return "redirect:/adminEditAUser";
    } 
    
}
