package com.epam.kharkiv.vet.service.person;

import com.epam.kharkiv.vet.api.service.person.IPetOwnerService;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.service.BaseServiceTest;

import com.epam.kharkiv.vet.service.utils.TestUtils;

public class PetOwnerServiceTest extends BaseServiceTest<IPetOwnerService, PetOwner> {

    @Override
    protected PetOwner generateRandomObject() {
        return TestUtils.createPetOwner();
    }

    @Override
    protected IPetOwnerService getService() {
        return new PetOwnerService();
    }


}
