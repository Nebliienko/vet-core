package com.epam.kharkiv.vet.api.service.pet;

import com.epam.kharkiv.vet.api.service.IBaseService;
import com.epam.kharkiv.vet.domain.pet.Pet;

import java.util.List;

/**
 * Implementation for Pet class
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IPetService extends IBaseService<Pet> {

    @Override
    public List<Pet> get();

    @Override
    public Pet get(String id);

    @Override
    public void insert(Pet obj);

    @Override
    public void update(Pet obj);

}
