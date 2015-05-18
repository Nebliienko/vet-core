package com.epam.kharkiv.vet.api.repository.pet;

import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.api.repository.IBaseRepository;

/**
 * Implementation for Pet objects
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IPetRepository extends IBaseRepository<Pet> {
    // Will be dinamically implemented (polymorphism style)
}
