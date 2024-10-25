package com.example.regera.Service.Impl;

import com.example.regera.Converter.CandidateDTOConverter;
import com.example.regera.Model.Candidate.CandidateDTO;
import com.example.regera.Repository.AccountRepository;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Repository.Entity.AccountEntity;
import com.example.regera.Repository.Entity.CandidateEntity;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Service.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateDTOConverter candidateDTOConverter;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CandidateDTO getCandidateById(int id) {
        return candidateDTOConverter.toCandidateDTO(candidateRepository.findById(id).get());
    }

    @Override
    public void addCandidate(CandidateEntity candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public CandidateEntity getCandidateByEmail(String email) {
        return candidateRepository.findByEmail(email);
    }

    @Override
    public CandidateDTO getCandidateByAccount(String username) {
        AccountEntity acc = accountRepository.findByUsername(username).get();
        CandidateEntity c = candidateRepository.findByAccount(acc);
        return candidateDTOConverter.toCandidateDTO(c);
    }

    @Override
    public void updateCandidate(CandidateEntity candidate, int id) {
        CandidateEntity c = candidateRepository.findById(id).get();
        try{
            Field[] fields = c.getClass().getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                if(field.get(candidate)!=null){
                    field.set(c,field.get(candidate));
                }
            }
            candidateRepository.save(c);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
