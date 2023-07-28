package com.anthonygarcia.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anthonygarcia.safetravels.models.Travels;

@Repository
public interface TravelsRepository extends CrudRepository<Travels, Long>{
    // this method retrieves all the books from the database
    List<Travels> findAll();
    // this method finds books with descriptions containing the search string
    List<Travels> findByExpenseNameContaining(String search);
    // this method counts how many titles contain a certain string
//    Long countByTravelsNameContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTravelsNameStartingWith(String search);
}
