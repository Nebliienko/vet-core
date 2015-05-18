package com.epam.kharkiv.vet.service.person;

import com.epam.kharkiv.vet.api.service.person.IPetOwnerService;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.service.BasicService;

import org.springframework.stereotype.Service;

/**
 * Repository for pet owner
 * 
 * @author Maksym_Nebliienko
 *
 */
@Service
public class PetOwnerService extends BasicService<PetOwner> implements IPetOwnerService {
    // Will be dinamically handled (polymorphysm in action)
}
