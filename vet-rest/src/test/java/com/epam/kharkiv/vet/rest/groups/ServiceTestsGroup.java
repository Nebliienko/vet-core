package com.epam.kharkiv.vet.rest.groups;

import com.epam.kharkiv.vet.service.person.PetOwnerServiceTest;
import com.epam.kharkiv.vet.service.person.VeterinaryServiceTest;
import com.epam.kharkiv.vet.service.pet.PetServiceTest;
import com.epam.kharkiv.vet.service.pet.VisitHistoryServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ PetOwnerServiceTest.class, VeterinaryServiceTest.class, PetServiceTest.class,
        VisitHistoryServiceTest.class })
public class ServiceTestsGroup {

}
