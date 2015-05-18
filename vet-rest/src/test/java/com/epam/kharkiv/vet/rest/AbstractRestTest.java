package com.epam.kharkiv.vet.rest;

import org.easymock.internal.MocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * The class AbstractRestTest.
 *
 * @author Maksym_Nebliienko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "/com.epam.kharkiv.vet.rest/rest-context-test.xml" })
public abstract class AbstractRestTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MocksControl control;

    @Before
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        control.resetToStrict();
    }

    @After
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        control.verify();
    }

    public MocksControl getControl() {
        return control;
    }
}
