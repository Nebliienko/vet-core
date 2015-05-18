package com.epam.kharkiv.vet.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import com.epam.kharkiv.vet.api.repository.person.IPetOwnerRepository;
import com.epam.kharkiv.vet.api.repository.pet.IPetRepository;
import com.epam.kharkiv.vet.api.rest.IPetRest;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.rest.constants.ViewConstants;
import com.epam.kharkiv.vet.service.utils.TestUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PetRestIntegrationTest extends RestIntegrationTest {

    @Autowired
    IPetRest petRest;
    @Autowired
    IPetRepository petRepository;
    @Autowired
    IPetOwnerRepository petOwnerRepository;

    @Test
    @Rollback
    public void testGetPetById() throws Exception {
        Pet pet = TestUtils.createPet();
        pet.setOwner(petOwnerRepository.get("mnebliienko"));
        petRepository.insert(pet);
        ModelAndView mv = petRest.getPetView(pet.getId());
        assertModelAttributeValue(mv, "pet", pet);
        assertViewName(mv, ViewConstants.PET_VIEW);

        petRepository.delete(pet.getId());
    }

    @Test
    public void testUpdatePetOwner() throws Exception {
        Pet pet = TestUtils.createPet();
        pet.setOwner(petOwnerRepository.get("mnebliienko"));
        pet.setId("mypet");

        ModelAndView mv = petRest.updatePet(pet, Mockito.mock(BindingResult.class), null);

        assertModelAttributeAvailable(mv, "pets");
        assertEquals(pet, ((List) mv.getModel().get("pets")).get(0));
        assertViewName(mv, ViewConstants.PET_LIST_VIEW);
    }
}