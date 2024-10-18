package com.example.regera.Service;

import com.example.regera.Model.Candidate.CandidateDTO;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Repository.Entity.CandidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CandidateService {
    public CandidateDTO getCandidateById(int id);
}
