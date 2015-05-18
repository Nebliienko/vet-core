package com.epam.kharkiv.vet.api.repository.person;

import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.api.repository.IBaseRepository;

/**
 * Implementation for PetOwner objects
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IPetOwnerRepository extends IBaseRepository<PetOwner> {
    // Will be dinamically implemented (polymorphism style)
}
