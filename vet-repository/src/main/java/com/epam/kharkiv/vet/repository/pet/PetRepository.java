package com.epam.kharkiv.vet.repository.pet;

import com.epam.kharkiv.vet.api.repository.pet.IPetRepository;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.repository.BaseRepository;

import org.springframework.stereotype.Repository;

/**
 * Repository for pet
 * 
 * @author Maksym_Nebliienko
 *
 */
@Repository
public class PetRepository extends BaseRepository<Pet> implements IPetRepository {

    @Override
    protected String getNamespace() {
        return "IPetMapper";
    }
}
