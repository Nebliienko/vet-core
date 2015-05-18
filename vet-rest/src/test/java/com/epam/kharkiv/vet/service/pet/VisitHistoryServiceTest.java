package com.epam.kharkiv.vet.service.pet;

import com.epam.kharkiv.vet.api.service.pet.IVisitHistoryService;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;
import com.epam.kharkiv.vet.service.BaseServiceTest;

import com.epam.kharkiv.vet.service.utils.TestUtils;

public class VisitHistoryServiceTest extends BaseServiceTest<IVisitHistoryService, VisitHistory> {

    @Override
    protected VisitHistory generateRandomObject() {
        return TestUtils.createVisitHistory();
    }

    @Override
    protected IVisitHistoryService getService() {
        return new VisitHistoryService();
    }

}
