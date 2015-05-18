package com.epam.kharkiv.vet.api.rest;

import org.springframework.web.servlet.ModelAndView;

public interface IVeterinaryRest {

    public ModelAndView getListOfVeterinaries();

    ModelAndView getVeterinary(String id);
    
}
