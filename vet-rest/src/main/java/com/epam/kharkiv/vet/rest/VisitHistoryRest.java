package com.epam.kharkiv.vet.rest;

import static com.epam.kharkiv.vet.rest.constants.PathVariables.CHANGE_PAGE_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.CREATE_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.GET_URL;
import static com.epam.kharkiv.vet.rest.constants.PathVariables.VISIT_HISTORY_URL;
import static com.epam.kharkiv.vet.rest.constants.ViewConstants.VISIT_HISTORY_LIST_VIEW;
import static com.epam.kharkiv.vet.rest.constants.ViewConstants.VISIT_HISTORY_VIEW;

import com.epam.kharkiv.vet.api.rest.IVisitHistoryRest;
import com.epam.kharkiv.vet.api.service.person.IVeterinaryService;
import com.epam.kharkiv.vet.api.service.pet.IVisitHistoryService;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;
import com.epam.kharkiv.vet.service.utils.IdGenerationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping(VISIT_HISTORY_URL)
public class VisitHistoryRest implements IVisitHistoryRest {

    @Autowired
    private IVisitHistoryService visitHistoryService;
    @Autowired
    private IVeterinaryService veterinaryService;
    @Autowired
    private IdGenerationHelper idGenerationHelper;

    @Override
    @RequestMapping(value = CHANGE_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView addPetVisitHistoryPage(@RequestParam String petId) {
        ModelAndView mv = new ModelAndView(VISIT_HISTORY_VIEW);
        VisitHistory visit = new VisitHistory();
        Pet pet= new Pet();
        pet.setId(petId);
        visit.setPet(pet);
        mv.addObject("visitHistory", visit);
        mv.addObject("veterinaries", veterinaryService.get());
        return mv;
    }

    @Override
    @RequestMapping(value = GET_URL, method = RequestMethod.GET)
    public ModelAndView getPetVisitHistory(@RequestParam String petId) {
        ModelAndView mv = new ModelAndView(VISIT_HISTORY_LIST_VIEW);
        List<VisitHistory> visits = visitHistoryService.getByPetId(petId);
        mv.addObject("petId", petId);
        mv.addObject("visits", visits);
        return mv;
    }

    @Override
    @RequestMapping(value = CREATE_URL, method = RequestMethod.POST)
    public ModelAndView addVisitHistory(@Valid VisitHistory history, BindingResult bindResult, Model m) {
        if (bindResult.hasErrors()) {
            m.addAttribute("veterinaries", veterinaryService.get());
            return new ModelAndView(VISIT_HISTORY_VIEW);
        }
        history.setId(idGenerationHelper.generate());
        visitHistoryService.insert(history);
        return getPetVisitHistory(history.getPet().getId());
    }

}
