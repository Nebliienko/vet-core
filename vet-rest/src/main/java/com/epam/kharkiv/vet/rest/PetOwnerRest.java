package com.epam.kharkiv.vet.rest;

import static com.epam.kharkiv.vet.rest.constants.PathVariables.CHANGE_PAGE_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.CREATE_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.GET_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.ID_PATH_VARIABLE;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.PET_OWNER_URL;
import static com.epam.kharkiv.vet.rest.constants.ViewConstants.PET_OWNER_LIST_VIEW;
import static com.epam.kharkiv.vet.rest.constants.ViewConstants.PET_OWNER_VIEW;

import com.epam.kharkiv.vet.api.rest.IPetOwnerRest;
import com.epam.kharkiv.vet.api.service.person.IPetOwnerService;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.service.utils.IdGenerationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping(PET_OWNER_URL)
public class PetOwnerRest implements IPetOwnerRest {

    @Autowired
    private IPetOwnerService petOwnerService;
    @Autowired
    private IdGenerationHelper idGenerationHelper;

    @Override
    @RequestMapping(value = GET_URL + ID_PATH_VARIABLE, method = RequestMethod.GET)
    public ModelAndView getPetOwnerById(@PathVariable String id) {
        ModelAndView mv = new ModelAndView(PET_OWNER_LIST_VIEW);
        PetOwner veterinary = petOwnerService.get(id);
        mv.addObject("petOwners", Collections.singletonList(veterinary));
        return mv;
    }

    @Override
    @RequestMapping(value = GET_URL, method = RequestMethod.GET)
    public ModelAndView getPetOwners() {
        ModelAndView mv = new ModelAndView(PET_OWNER_LIST_VIEW);
        List<PetOwner> petOwner = petOwnerService.get();
        mv.addObject("petOwners", petOwner);
        return mv;
    }

    @Override
    @RequestMapping(value = CHANGE_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView getPetOwnerView(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView(PET_OWNER_VIEW);
        PetOwner owner = petOwnerService.get(id);
        if (owner == null) {
            owner = new PetOwner();
        }
        mv.addObject("petOwner", owner);
        return mv;
    }

    @Override
    @RequestMapping(value = CREATE_URL, method = RequestMethod.POST)
    public ModelAndView updatePetOwner(@Valid PetOwner petOwner, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            return new ModelAndView(PET_OWNER_VIEW);
        }
        if (StringUtils.isEmpty(petOwner.getId())) {
            petOwner.setId(idGenerationHelper.generate());
            petOwnerService.insert(petOwner);
        } else {
            petOwnerService.update(petOwner);
        }
        return getPetOwners();
    }

}
