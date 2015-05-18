package com.epam.kharkiv.vet.repository.person;

import com.epam.kharkiv.vet.api.repository.person.IPetOwnerRepository;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.service.utils.TestUtils;

public class PetOwnerRepositoryTest extends BaseRepositoryTest<IPetOwnerRepository, PetOwner> {

    @Override
    protected PetOwner generateRandomObject() {
        return TestUtils.createPetOwner();
    }
}
