package com.epam.kharkiv.vet.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.kharkiv.vet.api.repository.IBaseRepository;
import com.epam.kharkiv.vet.api.service.IBaseService;
import com.epam.kharkiv.vet.api.test.FailScenarioTestGroup;
import com.epam.kharkiv.vet.api.test.SuccessfulScenarioTestGroup;
import com.epam.kharkiv.vet.domain.Identifiable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceTest<T extends IBaseService<S>, S extends Identifiable> {

    private T service = getService();
    private IBaseRepository<S> repository = Mockito.mock(IBaseRepository.class);
    private S object;

    @Before
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Whitebox.setInternalState(service, "repository", repository);
        object = generateRandomObject();
    }

    @After
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Mockito.verifyNoMoreInteractions(repository);
        Mockito.reset(repository);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGetAll() {
        when(repository.get()).thenReturn(new ArrayList<S>());

        List<S> actual = service.get();

        verify(repository).get();
        assertEquals(0, actual.size());
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testGet() {
        when(repository.get(anyString())).thenReturn(object);

        S actual = service.get("test");

        verify(repository).get("test");
        assertEquals(object, actual);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testInsert() {
        service.insert(object);

        verify(repository).insert(object);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testUpdate() {
        service.update(object);

        verify(repository).update(object);
    }

    @Test
    @org.testng.annotations.Test(groups = {"successfulScenarioTestGroup"})
    @Category(SuccessfulScenarioTestGroup.class)
    public void testDelete() {
        service.delete(object.getId());

        verify(repository).delete(object.getId());
    }

    protected abstract S generateRandomObject();

    protected abstract T getService();

    @Test
    @org.testng.annotations.Test(groups = {"failScenarioTestGroup"})
    @Category(FailScenarioTestGroup.class)
    public void testGetAllWhenRepositoryHasNoItemThenReturnNull() {
        when(repository.get()).thenReturn(null);

        List<S> actual = service.get();

        verify(repository).get();
        assertEquals(null, actual);
    }

    @Test
    @org.testng.annotations.Test(groups = {"failScenarioTestGroup"})
    @Category(FailScenarioTestGroup.class)
    public void testGetWhenRepositoryHasNoItemThenReturnNull() {
        when(repository.get(anyString())).thenReturn(null);

        S actual = service.get("test");

        verify(repository).get("test");
        assertEquals(null, actual);
    }
}
