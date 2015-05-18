package com.epam.kharkiv.vet.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeAvailable;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import com.epam.kharkiv.vet.api.repository.person.IPetOwnerRepository;
import com.epam.kharkiv.vet.api.rest.IPetOwnerRest;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.rest.constants.ViewConstants;
import com.epam.kharkiv.vet.service.utils.TestUtils;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

public class PetOwnerRestIntegrationTest extends RestIntegrationTest {

    @Autowired
    IPetOwnerRest petOwnerRest;
    @Autowired
    IPetOwnerRepository petOwnerRepository;

    @Test
    @Rollback
    public void testGetPetOwnerById() throws Exception {
        PetOwner petOwner = TestUtils.createPetOwner();
        petOwnerRepository.insert(petOwner);
        ModelAndView mv = petOwnerRest.getPetOwnerById(petOwner.getId());
        assertModelAttributeValue(mv, "petOwners", Collections.singletonList(petOwner));
        assertViewName(mv, ViewConstants.PET_OWNER_LIST_VIEW);

        petOwnerRepository.delete(petOwner.getId());
    }

    @Test
    public void testInsertPetOwner() throws Exception {
        PetOwner petOwner = TestUtils.createPetOwner();
        petOwner.setId(null);

        ModelAndView mv = petOwnerRest.updatePetOwner(petOwner, Mockito.mock(BindingResult.class));

        assertModelAttributeAvailable(mv, "petOwners");
        assertEquals(2, ((List) mv.getModel().get("petOwners")).size());
        assertViewName(mv, ViewConstants.PET_OWNER_LIST_VIEW);
    }

    @Test
    public void testUpdatePetOwner() throws Exception {
        PetOwner petOwner = TestUtils.createPetOwner();
        petOwner.setId("mnebliienko");

        ModelAndView mv = petOwnerRest.updatePetOwner(petOwner, Mockito.mock(BindingResult.class));

        assertModelAttributeAvailable(mv, "petOwners");
        assertEquals(petOwner, ((List) mv.getModel().get("petOwners")).get(0));
        assertViewName(mv, ViewConstants.PET_OWNER_LIST_VIEW);
    }
}