package com.example.regera.Repository.Impl;

import com.example.regera.Repository.ApplyJobRepository;
import com.example.regera.Repository.Custom.ApplyJobRepositoryCustom;
import com.example.regera.Repository.Entity.JobEntity;
import com.example.regera.Repository.Entity.applyJobEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplyJobRepositoryImpl implements ApplyJobRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<applyJobEntity> getAPByCandidateId(int candidateId) {
        String sql = "SELECT DISTINCT aj.* FROM apply_job aj " +
                "JOIN cv c ON aj.id_cv=c.id "+
                "JOIN candidate ca ON ca.id=c.id_candidate "+
                "WHERE c.id_candidate = "+candidateId;
        Query query = entityManager.createNativeQuery(sql, applyJobEntity.class);
        return query.getResultList();
    }
}
