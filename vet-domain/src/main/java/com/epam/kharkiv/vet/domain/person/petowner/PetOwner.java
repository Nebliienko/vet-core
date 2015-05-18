package com.epam.kharkiv.vet.domain.person.petowner;

import com.epam.kharkiv.vet.domain.person.Person;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * Class pet owner
 * 
 * @author Maksym_Nebliienko
 *
 */
public class PetOwner extends Person {

    @NotNull
    @Email(regexp = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
