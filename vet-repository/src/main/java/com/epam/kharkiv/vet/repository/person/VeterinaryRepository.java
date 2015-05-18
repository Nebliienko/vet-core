package com.epam.kharkiv.vet.repository.person;

import com.epam.kharkiv.vet.api.repository.person.IVeterinaryRepository;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.repository.BaseRepository;

import org.springframework.stereotype.Repository;

/**
 * Repository for veterinary
 * 
 * @author Maksym_Nebliienko
 *
 */
@Repository
public class VeterinaryRepository extends BaseRepository<Veterinary> implements IVeterinaryRepository {

    @Override
    protected String getNamespace() {
        return "IVeterinaryMapper";
    }
}
