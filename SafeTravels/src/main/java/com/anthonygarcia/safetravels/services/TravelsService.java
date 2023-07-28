package com.anthonygarcia.safetravels.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthonygarcia.safetravels.models.Travels;
import com.anthonygarcia.safetravels.repositories.TravelsRepository;

@Service
public class TravelsService {
	    // adding the object repository as a dependency
		@Autowired
	    private TravelsRepository travelsRepository;
	    
	    // returns all the object
	    public List<Travels> allTravels() {
	        return travelsRepository.findAll();
	    }
	    // creates a object
	    public Travels createTravel(Travels t) {
	        return travelsRepository.save(t);
	    }
	    // update a object - it's the same as create, however if a primary key already exists, it will update instead of create.
	    public Travels updateTravel(Travels t) {
	        return travelsRepository.save(t);
	    }
	    // retrieves a object
	    public Travels findTravel(Long id) {
	        Optional<Travels> optionalBurger = travelsRepository.findById(id);
	        if(optionalBurger.isPresent()) {
	            return optionalBurger.get();
	        } else {
	            return null;
	        }
	    }
	    // delete a object
	    public void deleteTravel(Long id) {
	    	travelsRepository.deleteById(id);
	    }
	    //will return any objects that contain the "search" string.
	    public List<Travels> travelsContaining(String search) {
	    	return travelsRepository.findByExpenseNameContaining(search);
	}


}
