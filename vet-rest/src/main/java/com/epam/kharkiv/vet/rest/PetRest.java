package com.epam.kharkiv.vet.rest;

import static com.epam.kharkiv.vet.rest.constants.PathVariables.CHANGE_PAGE_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.CREATE_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.GET_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.PET_URL;
import static com.epam.kharkiv.vet.rest.constants.ViewConstants.PET_LIST_VIEW;
import static com.epam.kharkiv.vet.rest.constants.ViewConstants.PET_VIEW;

import com.epam.kharkiv.vet.api.rest.IPetRest;
import com.epam.kharkiv.vet.api.service.person.IPetOwnerService;
import com.epam.kharkiv.vet.api.service.pet.IPetService;
import com.epam.kharkiv.vet.domain.enumeration.ESpecies;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.service.utils.IdGenerationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(PET_URL)
public class PetRest implements IPetRest {

    @Autowired
    private IPetService petService;
    @Autowired
    private IPetOwnerService petOwnerService;
    @Autowired
    @Qualifier("petValidator")
    private Validator validator;
    @Autowired
    private IdGenerationHelper idGenerationHelper;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @Override
    @RequestMapping(value = GET_URL, method = RequestMethod.GET)
    public ModelAndView getPets() {
        ModelAndView mv = new ModelAndView(PET_LIST_VIEW);
        List<Pet> pets = petService.get();
        mv.addObject("pets", pets);
        return mv;
    }

    @Override
    @RequestMapping(value = CHANGE_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView getPetView(@RequestParam(required = false) String id) {
        ModelAndView mv = new ModelAndView(PET_VIEW);
        Pet pet = petService.get(id);
        if (pet == null) {
            pet = new Pet();
        }
        mv.addObject("pet", pet);
        mv.addObject("species", ESpecies.values());
        mv.addObject("petOwners", petOwnerService.get());
        return mv;
    }

    @Override
    @RequestMapping(value = CREATE_URL, method = RequestMethod.POST)
    public ModelAndView updatePet(@Validated Pet pet, BindingResult bindResult, Model m) {
        if (bindResult.hasErrors()) {
            m.addAttribute("species", ESpecies.values());
            m.addAttribute("petOwners", petOwnerService.get());
            return new ModelAndView(PET_VIEW);
        }
        if (StringUtils.isEmpty(pet.getId())) {
            pet.setId(idGenerationHelper.generate());
            petService.insert(pet);
        } else {
            petService.update(pet);
        }
        return getPets();
    }

}
