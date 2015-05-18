package com.epam.kharkiv.vet.service.person;

import com.epam.kharkiv.vet.api.service.person.IVeterinaryService;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.service.BaseServiceTest;

import com.epam.kharkiv.vet.service.utils.TestUtils;

public class VeterinaryServiceTest extends BaseServiceTest<IVeterinaryService, Veterinary> {

    @Override
    protected Veterinary generateRandomObject() {
        return TestUtils.createVeterinary();
    }

    @Override
    protected IVeterinaryService getService() {
        return new VeterinaryService();
    }

}
