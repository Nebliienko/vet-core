package com.epam.kharkiv.vet.repository.pet;

import com.epam.kharkiv.vet.api.repository.pet.IPetRepository;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.api.repository.person.IPetOwnerRepository;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.service.utils.TestUtils;

import org.springframework.beans.factory.annotation.Autowired;

public class PetRepositoryTest extends BaseRepositoryTest<IPetRepository, Pet> {

    @Autowired
    private IPetOwnerRepository repository;

    @Override
    protected Pet generateRandomObject() {
        Pet pet = TestUtils.createPet();
        repository.insert(pet.getOwner());
        return pet;
    }

}
