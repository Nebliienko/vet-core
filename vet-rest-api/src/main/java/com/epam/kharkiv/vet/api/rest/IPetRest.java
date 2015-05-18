package com.epam.kharkiv.vet.api.rest;

import com.epam.kharkiv.vet.domain.pet.Pet;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IPetRest {

    public ModelAndView getPets();

    public ModelAndView getPetView(String id);

    public ModelAndView updatePet(Pet pet, BindingResult bindResult, Model m);
}
