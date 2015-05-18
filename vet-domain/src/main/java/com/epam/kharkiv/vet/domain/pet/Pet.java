package com.epam.kharkiv.vet.domain.pet;

import com.epam.kharkiv.vet.domain.Identifiable;
import com.epam.kharkiv.vet.domain.enumeration.ESpecies;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;

/**
 * Class pet
 * 
 * @author Maksym_Nebliienko
 *
 */
public class Pet extends Identifiable {

    private String moniker;
    private PetOwner petOwner;
    private Integer age;
    private ESpecies species;

    public String getMoniker() {
        return moniker;
    }

    public void setMoniker(String moniker) {
        this.moniker = moniker;
    }

    public PetOwner getOwner() {
        return petOwner;
    }

    public void setOwner(PetOwner owner) {
        this.petOwner = owner;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ESpecies getSpecies() {
        return species;
    }

    public void setSpecies(ESpecies species) {
        this.species = species;
    }

}
