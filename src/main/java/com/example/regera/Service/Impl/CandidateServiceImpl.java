package com.example.regera.Service.Impl;

import com.example.regera.Converter.CandidateDTOConverter;
import com.example.regera.Model.Candidate.CandidateDTO;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateDTOConverter candidateDTOConverter;

    @Override
    public CandidateDTO getCandidateById(int id) {
        return candidateDTOConverter.toCandidateDTO(candidateRepository.findById(id).get());
    }
}
