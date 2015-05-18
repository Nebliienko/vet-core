package com.epam.kharkiv.vet.service.utils;

import com.epam.kharkiv.vet.domain.enumeration.ESpecialization;
import com.epam.kharkiv.vet.domain.enumeration.ESpecies;
import com.epam.kharkiv.vet.domain.person.petowner.PetOwner;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.domain.pet.Pet;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class TestUtils {

    public static PetOwner createPetOwner() {
        PetOwner petOwner = new PetOwner();
        petOwner.setId(UUID.randomUUID().toString());
        petOwner.setName(RandomStringUtils.random(8));
        petOwner.setSurname(RandomStringUtils.random(8));
        petOwner.setAge(new Random().nextInt());
        petOwner.setEmail(RandomStringUtils.random(8));
        return petOwner;
    }

    public static Veterinary createVeterinary() {
        Veterinary veterinary = new Veterinary();
        veterinary.setId(UUID.randomUUID().toString());
        veterinary.setName(RandomStringUtils.random(8));
        veterinary.setSurname(RandomStringUtils.random(8));
        veterinary.setAge(new Random().nextInt());
        veterinary.setSpecialization(ESpecialization.DOMESTIC);
        return veterinary;
    }

    public static Pet createPet() {
        Pet pet = new Pet();
        pet.setId(UUID.randomUUID().toString());
        pet.setMoniker(RandomStringUtils.random(8));
        pet.setOwner(createPetOwner());
        pet.setAge(new Random().nextInt());
        pet.setSpecies(ESpecies.CAT);
        return pet;
    }

    public static VisitHistory createVisitHistory() {
        VisitHistory visitHistory = new VisitHistory();
        visitHistory.setId(UUID.randomUUID().toString());
        visitHistory.setInformation(RandomStringUtils.random(255));
        visitHistory.setPet(createPet());
        visitHistory.setVeterinary(createVeterinary());
        visitHistory.setVisitTime(new Date());
        visitHistory.setReason(RandomStringUtils.random(8));
        return visitHistory;
    }
}
