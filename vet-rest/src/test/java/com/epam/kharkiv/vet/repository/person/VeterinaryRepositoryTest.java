package com.epam.kharkiv.vet.repository.person;

import com.epam.kharkiv.vet.api.repository.person.IVeterinaryRepository;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.service.utils.TestUtils;

public class VeterinaryRepositoryTest extends BaseRepositoryTest<IVeterinaryRepository, Veterinary> {

	@Override
	protected Veterinary generateRandomObject() {
        return TestUtils.createVeterinary();
	}

}
