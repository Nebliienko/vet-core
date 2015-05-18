package com.epam.kharkiv.vet.api.rest;

import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface IVisitHistoryRest {

    ModelAndView getPetVisitHistory(String petId);

    ModelAndView addPetVisitHistoryPage(String petId);

    ModelAndView addVisitHistory(VisitHistory history, BindingResult bindResult, Model m);
}
