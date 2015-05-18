package com.epam.kharkiv.vet.repository.pet;

import com.epam.kharkiv.vet.api.repository.pet.IVisitHistoryRepository;
import com.epam.kharkiv.vet.domain.pet.visit.VisitHistory;
import com.epam.kharkiv.vet.repository.BaseRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for visit history
 * 
 * @author Maksym_Nebliienko
 *
 */
@Repository
public class VisitHistoryRepository extends BaseRepository<VisitHistory> implements IVisitHistoryRepository {

    @Override
    protected String getNamespace() {
        return "IVisitHistoryMapper";
    }

    @Override
    public List<VisitHistory> getByPetId(String petId) {
        return getTemplate().selectList(getNamespace() + ".getByPetId", petId);
    }
}
