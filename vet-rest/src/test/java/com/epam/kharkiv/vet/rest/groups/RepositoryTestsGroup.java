package com.epam.kharkiv.vet.rest.groups;

import com.epam.kharkiv.vet.repository.person.PetOwnerRepositoryTest;
import com.epam.kharkiv.vet.repository.person.VeterinaryRepositoryTest;
import com.epam.kharkiv.vet.repository.pet.PetRepositoryTest;
import com.epam.kharkiv.vet.repository.pet.VisitHistoryRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PetOwnerRepositoryTest.class, VeterinaryRepositoryTest.class, PetRepositoryTest.class,
        VisitHistoryRepositoryTest.class })
public class RepositoryTestsGroup {

}
