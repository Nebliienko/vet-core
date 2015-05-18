package com.epam.kharkiv.vet.rest;

import static com.epam.kharkiv.vet.service.utils.TestUtils.createPet;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertArrayEquals;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import com.epam.kharkiv.vet.api.service.person.IPetOwnerService;
import com.epam.kharkiv.vet.api.service.pet.IPetService;
import com.epam.kharkiv.vet.api.test.SuccessfulScenarioTestGroup;
import com.epam.kharkiv.vet.domain.enumeration.ESpecies;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.rest.constants.ViewConstants;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetRestTest extends AbstractRestTest {

    @Autowired
    private IPetService petService;
    @Autowired
    private IPetOwnerService petOwnerService;
    @Autowired
    @Qualifier("petValidator")
    private Validator validator;
    @Autowired
    private PetRest petRest;

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGetPets() throws Exception {
        List<Pet> pets = new ArrayList<>();
        pets.add(createPet());
        pets.add(createPet());

        expect(petService.get()).andReturn(pets);
        getControl().replay();

        ModelAndView mv = petRest.getPets();

        assertModelAttributeValue(mv, "pets", pets);
        assertViewName(mv, ViewConstants.PET_LIST_VIEW);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGetPetView() throws Exception {
        Pet pet = createPet();
        List<PetOwner> owners = Collections.emptyList();

        expect(petService.get(pet.getId())).andReturn(pet);
        expect(petOwnerService.get()).andReturn(owners);
        getControl().replay();

        ModelAndView mv = petRest.getPetView(pet.getId());


        assertArrayEquals(ESpecies.values(), (Object[]) mv.getModel().get("species"));
        assertModelAttributeValue(mv, "petOwners", owners);
        assertModelAttributeValue(mv, "pet", pet);
        assertViewName(mv, ViewConstants.PET_VIEW);
    }
}