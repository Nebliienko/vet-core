package com.epam.kharkiv.vet.service.pet;

import com.epam.kharkiv.vet.api.service.pet.IVisitHistoryService;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;
import com.epam.kharkiv.vet.api.repository.pet.IVisitHistoryRepository;
import com.epam.kharkiv.vet.service.BasicService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository for visit history
 * 
 * @author Maksym_Nebliienko
 *
 */
@Service
public class VisitHistoryService extends BasicService<VisitHistory> implements IVisitHistoryService {

    @Override
    public List<VisitHistory> getByPetId(String petId) {
        return ((IVisitHistoryRepository) repository).getByPetId(petId);
    }
    // Will be dinamically handled (polymorphysm in action)
}
