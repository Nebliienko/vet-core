package com.epam.kharkiv.vet.service.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * The class IdGenerationHelper.
 *
 * @author Maksym_Nebliienko
 */
@Component
public class IdGenerationHelper {

    public String generate(){
        return UUID.randomUUID().toString();
    }
}
