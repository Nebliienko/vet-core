package com.epam.kharkiv.vet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.epam.kharkiv.vet.api.repository.IBaseRepository;
import com.epam.kharkiv.vet.api.test.SuccessfulScenarioTestGroup;
import com.epam.kharkiv.vet.domain.Identifiable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:com/epam/kharkiv/vet/repository/db-config-test.groovy"})
public abstract class BaseRepositoryTest<T extends IBaseRepository<S>, S extends Identifiable>
    extends AbstractTestNGSpringContextTests {

    @Autowired
    protected T repository;
    protected S object1;
    protected S object2;

    @Before
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        object1 = generateRandomObject();
        object2 = generateRandomObject();
        repository.insert(object1);
        repository.insert(object2);
    }

    @After
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        repository.delete(object1.getId());
        repository.delete(object2.getId());
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void getList() {
        List<S> objects = repository.get();
        assertNotNull(objects);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void get() {
        S object = repository.get(object1.getId());
        assertEquals(object1, object);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void insert() {
        S object = generateRandomObject();
        repository.insert(object);
        assertEquals(object, repository.get(object.getId()));
        repository.delete(object.getId());
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void update() {
        String id = object1.getId();
        object1 = generateRandomObject();
        object1.setId(id);
        repository.update(object1);
        assertEquals(object1, repository.get(id));
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void delete() {
        repository.delete(object1.getId());
        assertNull(repository.get(object1.getId()));
    }

    protected abstract S generateRandomObject();
}
