package com.epam.kharkiv.vet.domain;

import org.junit.Test;

import test.util.PojoTestUtil;

/**
 * class to test pojo classes.
 */
public class PojoTest {

    private String[] pojoPackages = { "com.epam.kharkiv.vet.domain" };

    private PojoTestUtil pojoTestUtil = new PojoTestUtil();

    @Test
    public void testPojos() {
        pojoTestUtil.setPojoPackages(pojoPackages);
        pojoTestUtil.testPojos();
    }

}
