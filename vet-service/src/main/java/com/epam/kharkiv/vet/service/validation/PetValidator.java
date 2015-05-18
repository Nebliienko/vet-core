package com.epam.kharkiv.vet.service.validation;

import com.epam.kharkiv.vet.domain.pet.Pet;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PetValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Pet.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "moniker", "pet.moniker.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "pet.age.empty");
        Pet pet = (Pet) target;
        if (pet.getAge() != null) {
            if (pet.getAge() < 0) {
                errors.rejectValue("age", "pet.age.negative");
            } else if (pet.getAge() > 30) {
                errors.rejectValue("age", "pet.age.old");
            }
        }
    }

}
