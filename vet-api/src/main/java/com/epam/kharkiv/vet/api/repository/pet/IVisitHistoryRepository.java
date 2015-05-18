package com.epam.kharkiv.vet.api.repository.pet;

import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;
import com.epam.kharkiv.vet.api.repository.IBaseRepository;

import java.util.List;

/**
 * Implementation for VisitHistory objects
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IVisitHistoryRepository extends IBaseRepository<VisitHistory> {
    // Will be dinamically implemented (polymorphism style)

    List<VisitHistory> getByPetId(String petId);
}
