package com.epam.kharkiv.vet.rest;

import static com.epam.kharkiv.vet.rest.constants.PathVariables.GET_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.VETERINARY_URL;

import com.epam.kharkiv.vet.api.rest.IVeterinaryRest;
import com.epam.kharkiv.vet.api.service.person.IVeterinaryService;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.rest.constants.ViewConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(VETERINARY_URL)
public class VeterinaryRest implements IVeterinaryRest {

    @Autowired
    private IVeterinaryService veterinaryService;

    @Override
    @RequestMapping(value = GET_URL + "/{id}", method = RequestMethod.GET)
    public ModelAndView getVeterinary(@PathVariable String id) {
        ModelAndView mv = new ModelAndView(ViewConstants.VETERINARY_LIST_VIEW);
        Veterinary veterinary = veterinaryService.get(id);
        mv.addObject("veterinaries", Collections.singletonList(veterinary));
        return mv;
    }

    @Override
    @RequestMapping(value = GET_URL, method = RequestMethod.GET)
    public ModelAndView getListOfVeterinaries() {
        ModelAndView mv = new ModelAndView(ViewConstants.VETERINARY_LIST_VIEW);
        List<Veterinary> veterinaries = veterinaryService.get();
        mv.addObject("veterinaries", veterinaries);
        return mv;
    }

}
