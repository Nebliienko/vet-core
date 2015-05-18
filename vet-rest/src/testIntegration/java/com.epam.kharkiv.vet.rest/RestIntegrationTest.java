package com.epam.kharkiv.vet.rest;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * The class RestIntegrationTest.
 *
 * @author Maksym_Nebliienko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@ContextConfiguration("classpath:integration-test-context.groovy")
public abstract class RestIntegrationTest {


}
