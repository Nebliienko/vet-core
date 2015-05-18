package com.epam.kharkiv.vet.service.pet;

import com.epam.kharkiv.vet.api.service.pet.IPetService;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.service.BaseServiceTest;

import com.epam.kharkiv.vet.service.utils.TestUtils;

public class PetServiceTest extends BaseServiceTest<IPetService, Pet> {

    @Override
    protected Pet generateRandomObject() {
        return TestUtils.createPet();
    }

    @Override
    protected IPetService getService() {
        return new PetService();
    }


}
