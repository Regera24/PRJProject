package com.example.regera.API;

import com.example.regera.Model.Candidate.CandidateDTO;
import com.example.regera.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateAPI {
    @Autowired
    private CandidateService candidateService;

    @GetMapping(value = "/candidate/{id}")
    public CandidateDTO getCandidateById(@PathVariable int id) {
        return candidateService.getCandidateById(id);
    }
}
