package com.epam.kharkiv.vet.api.rest;

import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IPetOwnerRest {

    public ModelAndView getPetOwnerById(String id);

    ModelAndView getPetOwners();

    ModelAndView getPetOwnerView(String id);

    ModelAndView updatePetOwner(PetOwner owner, BindingResult bindResult);

}
