package com.epam.kharkiv.vet.repository.person;

import com.epam.kharkiv.vet.api.repository.person.IPetOwnerRepository;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.repository.BaseRepository;

import org.springframework.stereotype.Repository;

/**
 * Repository for pet owner
 * 
 * @author Maksym_Nebliienko
 *
 */
@Repository
public class PetOwnerRepository extends BaseRepository<PetOwner> implements IPetOwnerRepository {

    @Override
    protected String getNamespace() {
        return "IPetOwnerMapper";
    }
}
