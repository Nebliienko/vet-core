package com.epam.kharkiv.vet.domain.pet.visit;

import com.epam.kharkiv.vet.domain.Identifiable;
import com.epam.kharkiv.vet.domain.person.veterinary.Veterinary;
import com.epam.kharkiv.vet.domain.pet.Pet;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * Class visit history
 * 
 * @author Maksym_Nebliienko
 *
 */
public class VisitHistory extends Identifiable {

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past
    private Date visitTime;
    @Size(min = 2, max = 30)
    private String reason;
    private Pet pet;
    private Veterinary veterinary;
    private String information;

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Veterinary getVeterinary() {
        return veterinary;
    }

    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
