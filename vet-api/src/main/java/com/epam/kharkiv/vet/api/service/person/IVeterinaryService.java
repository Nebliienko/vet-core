package com.epam.kharkiv.vet.api.service.person;

import com.epam.kharkiv.vet.api.service.IBaseService;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;

import java.util.List;

/**
 * Implementation for Veterinary class
 * 
 * @author Maksym_Nebliienko
 *
 */
public interface IVeterinaryService extends IBaseService<Veterinary> {

    @Override
    public List<Veterinary> get();

    @Override
    public Veterinary get(String id);

    @Override
    public void insert(Veterinary obj);

    @Override
    public void update(Veterinary obj);

}
