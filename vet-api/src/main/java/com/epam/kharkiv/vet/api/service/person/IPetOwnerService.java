package com.epam.kharkiv.vet.api.service.person;

import com.epam.kharkiv.vet.api.service.IBaseService;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;

import java.util.List;

/**
 * Implementation for PetOwner class
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IPetOwnerService extends IBaseService<PetOwner> {

    @Override
    public List<PetOwner> get();

    @Override
    public PetOwner get(String id);

    @Override
    public void insert(PetOwner obj);

    @Override
    public void update(PetOwner obj);

}
