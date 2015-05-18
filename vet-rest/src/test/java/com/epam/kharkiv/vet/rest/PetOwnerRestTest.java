package com.epam.kharkiv.vet.rest;

import static com.epam.kharkiv.vet.service.utils.TestUtils.createPetOwner;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

import com.epam.kharkiv.vet.api.service.person.IPetOwnerService;
import com.epam.kharkiv.vet.api.test.SuccessfulScenarioTestGroup;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.rest.constants.ViewConstants;
import com.epam.kharkiv.vet.service.utils.IdGenerationHelper;
import com.epam.kharkiv.vet.service.utils.TestUtils;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetOwnerRestTest extends AbstractRestTest {


    @Autowired
    private IPetOwnerService petOwnerService;
    @Autowired
    private PetOwnerRest petOwnerRest;
    @Autowired
    private IdGenerationHelper idGenerationHelper;

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGetOwners() throws Exception {
        List<PetOwner> petOwners = new ArrayList<>();
        petOwners.add(createPetOwner());
        petOwners.add(createPetOwner());

        expect(petOwnerService.get()).andReturn(petOwners);
        getControl().replay();

        ModelAndView mv = petOwnerRest.getPetOwners();

        assertModelAttributeValue(mv, "petOwners", petOwners);
        assertViewName(mv, ViewConstants.PET_OWNER_LIST_VIEW);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGetOwnersById() throws Exception {
        PetOwner owner = TestUtils.createPetOwner();

        expect(petOwnerService.get(owner.getId())).andReturn(owner);
        getControl().replay();

        ModelAndView mv = petOwnerRest.getPetOwnerById(owner.getId());

        assertModelAttributeValue(mv, "petOwners", Collections.singletonList(owner));
        assertViewName(mv, ViewConstants.PET_OWNER_LIST_VIEW);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGetPetView() throws Exception {
        PetOwner owner = TestUtils.createPetOwner();

        expect(petOwnerService.get(owner.getId())).andReturn(owner);
        getControl().replay();

        ModelAndView mv = petOwnerRest.getPetOwnerView(owner.getId());

        assertViewName(mv, ViewConstants.PET_OWNER_VIEW);
        assertModelAttributeValue(mv, "petOwner", owner);
    }


    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testUpdatePetOwner() throws Exception {
        PetOwner owner = TestUtils.createPetOwner();
        IdGenerationHelper helper = Mockito.spy(idGenerationHelper);
        Whitebox.setInternalState(petOwnerRest, "idGenerationHelper", helper);
        owner.setId(null);
        BindingResult result = Mockito.mock(BindingResult.class);

        Mockito.when(helper.generate()).thenReturn(idGenerationHelper.generate().concat("_testOnly"));
        Mockito.when(result.hasErrors()).thenReturn(false);
        petOwnerService.insert(EasyMock.anyObject(PetOwner.class));
        expect(petOwnerService.get()).andReturn(Collections.singletonList(owner));
        getControl().replay();

        ModelAndView mv = petOwnerRest.updatePetOwner(owner, result);

        assertViewName(mv, ViewConstants.PET_OWNER_LIST_VIEW);
        assertNotNull(owner.getId());
        assertTrue(owner.getId().contains("_testOnly"));
        Mockito.verify(result).hasErrors();
        Mockito.verify(helper).generate();
        Mockito.verifyNoMoreInteractions(result);
    }
}