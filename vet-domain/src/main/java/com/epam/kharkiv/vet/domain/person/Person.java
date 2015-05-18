package com.epam.kharkiv.vet.domain.person;

import com.epam.kharkiv.vet.domain.Identifiable;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class indicates that object has name, surname and age fields
 * 
 * @author Maksym_Nebliienko
 *
 */
public class Person extends Identifiable {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;
    @NotEmpty
    @Size(min = 2, max = 30)
    private String surname;
    @NotNull
    @Digits(fraction = 0, integer = 3)
    @Min(0)
    @Max(120)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
