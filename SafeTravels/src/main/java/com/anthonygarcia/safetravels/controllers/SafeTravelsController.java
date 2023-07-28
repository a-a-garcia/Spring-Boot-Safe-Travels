package com.anthonygarcia.safetravels.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anthonygarcia.safetravels.models.Travels;
import com.anthonygarcia.safetravels.services.TravelsService;

import jakarta.validation.Valid;

@Controller
public class SafeTravelsController {
	@Autowired
    private TravelsService travelsService;

    
//    SHOW ALL OBJECTS
    @RequestMapping("/expenses")
    public String index(Model model, @ModelAttribute("travel") Travels travels) { 
    	List<Travels> allTravels = travelsService.allTravels();
    	model.addAttribute("allTravels", allTravels); //remember model takes two params -1) what it will be referred to in the jsp, 2) what it's called via Service.
    	return "index.jsp";
    }
//
//    
////    CREATE NEW OBJECT
    @PostMapping("/expenses/create")
    public String create(@Valid @ModelAttribute("travel") Travels travels, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		List<Travels> allTravels = travelsService.allTravels();
    		model.addAttribute("allTravels", allTravels); 
    		return "index.jsp";
    	} else {
    		travelsService.createTravel(travels);
    		return "redirect:/expenses";
    		}
    	}

//    EDIT PAGE
    @GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
    	Travels travel = travelsService.findTravel(id);
    	model.addAttribute("travel", travel);
    	return "edit.jsp";
    }
//    
////    EDIT SUBMIT
    @RequestMapping(value="/expenses/edit/{id}/submit", method=RequestMethod.PUT) //in the future, don't pass the id into the URL if you don't have to. just make this "/expenses/update"
    public String update(@Valid @ModelAttribute("travel") Travels travel, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		model.addAttribute("travel", travel);
    		return "edit.jsp";
    	} else {
    		travelsService.updateTravel(travel);
    		return "redirect:/expenses";
    	}
    }
//    
////    DELETE 
    @DeleteMapping("/expenses/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        travelsService.deleteTravel(id);
        return "redirect:/expenses";
    }
   }
//You can use this to print whats in bindingResult to see the validation errors:
//System.out.println("Validation errors:");
//for (ObjectError error : result.getAllErrors()) {
//	System.out.println(error.getDefaultMessage());