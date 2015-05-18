package com.epam.kharkiv.vet.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Identifies that object stored id field
 * 
 * @author Maksym_Nebliienko
 *
 */
public class Identifiable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Identifiable other = (Identifiable) obj;
        return new EqualsBuilder().append(id, other.getId()).build();
    }

}
