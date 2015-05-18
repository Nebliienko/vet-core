package com.epam.kharkiv.vet.repository.pet;

import static org.junit.Assert.assertEquals;

import com.epam.kharkiv.vet.api.repository.person.IPetOwnerRepository;
import com.epam.kharkiv.vet.api.repository.person.IVeterinaryRepository;
import com.epam.kharkiv.vet.api.repository.pet.IPetRepository;
import com.epam.kharkiv.vet.api.repository.pet.IVisitHistoryRepository;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.repository.BaseRepositoryTest;
import com.epam.kharkiv.vet.service.utils.TestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VisitHistoryRepositoryTest extends BaseRepositoryTest<IVisitHistoryRepository, VisitHistory> {

    @Autowired
    private IPetRepository petRepository;
    @Autowired
    private IVeterinaryRepository veterinaryRepository;
    @Autowired
    private IPetOwnerRepository petOwnerRepository;

    @Override
    protected VisitHistory generateRandomObject() {
        VisitHistory visitHistory = TestUtils.createVisitHistory();
        petOwnerRepository.insert(visitHistory.getPet().getOwner());
        petRepository.insert(visitHistory.getPet());
        veterinaryRepository.insert(visitHistory.getVeterinary());
        return visitHistory;
    }

    @Test
    public void getListByPetId() {
        List<VisitHistory> objects = repository.getByPetId(object1.getPet().getId());
        assertEquals(1, objects.size());
        assertEquals(object1, objects.get(0));
    }

}
