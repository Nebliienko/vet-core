package com.epam.kharkiv.vet.service.person;

import com.epam.kharkiv.vet.api.service.person.IVeterinaryService;
/**
 * Repository for veterinary
 * 
 * @author Maksym_Nebliienko
 *
 */
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.service.BasicService;

import org.springframework.stereotype.Service;

@Service
public class VeterinaryService extends BasicService<Veterinary> implements IVeterinaryService {
    // Will be dinamically handled (polymorphysm in action)
}
