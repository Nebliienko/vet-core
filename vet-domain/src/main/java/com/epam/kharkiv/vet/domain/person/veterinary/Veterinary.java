package com.epam.kharkiv.vet.domain.person.veterinary;

import com.epam.kharkiv.vet.domain.enumeration.ESpecialization;
import com.epam.kharkiv.vet.domain.person.Person;

/**
 * Class veterinary
 * 
 * @author Maksym_Nebliienko
 *
 */
public class Veterinary extends Person {

    private ESpecialization specialization;

    public ESpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(ESpecialization specialization) {
        this.specialization = specialization;
    }

}
