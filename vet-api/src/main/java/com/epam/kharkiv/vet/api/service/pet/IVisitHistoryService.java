package com.epam.kharkiv.vet.api.service.pet;

import com.epam.kharkiv.vet.api.service.IBaseService;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;

import java.util.List;

/**
 * Implementation for VisitHistory class
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IVisitHistoryService extends IBaseService<VisitHistory> {

    @Override
    public List<VisitHistory> get();

    @Override
    public VisitHistory get(String id);

    @Override
    public void insert(VisitHistory obj);

    @Override
    public void update(VisitHistory obj);

    /**
     * Gets visitation history related to single pet
     * 
     * @param petId id of the pet
     * @return list of visitations
     */
    List<VisitHistory> getByPetId(String petId);

}
