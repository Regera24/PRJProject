package com.example.regera.Repository.Custom;

import com.example.regera.Repository.Entity.applyJobEntity;

import java.util.List;

public interface ApplyJobRepositoryCustom {
    public List<applyJobEntity> getAPByCandidateId(int CandidateId);
}
