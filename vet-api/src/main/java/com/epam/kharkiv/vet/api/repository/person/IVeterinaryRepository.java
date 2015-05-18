package com.epam.kharkiv.vet.api.repository.person;

import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.api.repository.IBaseRepository;

/**
 * Implementation for Veterinary objects
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IVeterinaryRepository extends IBaseRepository<Veterinary> {
    // Will be dinamically implemented (polymorphism style)
}
