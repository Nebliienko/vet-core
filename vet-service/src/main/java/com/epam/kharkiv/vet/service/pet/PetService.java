package com.epam.kharkiv.vet.service.pet;

import com.epam.kharkiv.vet.api.service.pet.IPetService;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.service.BasicService;

import org.springframework.stereotype.Service;

/**
 * Repository for pet
 * 
 * @author Maksym_Nebliienko
 *
 */
@Service
public class PetService extends BasicService<Pet> implements IPetService {
    // Will be dinamically handled (polymorphysm in action)
}
