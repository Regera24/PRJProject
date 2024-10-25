package com.example.regera.API.Public;

import com.example.regera.Model.Request.CandidateCreateRequest;
import com.example.regera.Model.Request.CompanyCreateRequest;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Repository.Entity.AccountEntity;
import com.example.regera.Repository.Entity.CandidateEntity;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Repository.RoleRepository;
import com.example.regera.Service.AuthenticationService;
import com.example.regera.Service.CandidateService;
import com.example.regera.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterAPI {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CandidateService candidateService;

    @PostMapping(value = "check/register/company")
    public ResponseEntity<Void> registerCompany(@RequestBody CompanyCreateRequest companyCreateRequest) {
        companyService.addCompany(companyCreateRequest.getCompany());
        AccountEntity accountEntity = companyCreateRequest.getAccount();
        accountEntity.setCompany(companyService.getCompanyEntityByEmail(companyCreateRequest.getCompany().getEmail()));
        accountEntity.setActive(1);
        accountEntity.setRole(roleRepository.findById(2).get());
        authenticationService.addAccount(accountEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping(value="check/register/candidate")
    public ResponseEntity<Void> registerCandidate(@RequestBody CandidateCreateRequest candidateCreateRequest) {
        candidateService.addCandidate(candidateCreateRequest.getCandidate());
        AccountEntity accountEntity = candidateCreateRequest.getAccount();
        accountEntity.setCandidate(candidateService.getCandidateByEmail(candidateCreateRequest.getCandidate().getEmail()));
        accountEntity.setActive(1);
        accountEntity.setRole(roleRepository.findById(1).get());
        authenticationService.addAccount(accountEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping(value="/check/account")
    public ResponseEntity<Void> checkAccount(@RequestBody AccountEntity account) {
        if (authenticationService.checkAccount(account.getUsername())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value="/check/candidate")
    public ResponseEntity<String> checkCandidate(@RequestBody CandidateEntity candidate) {
        String s = "";
        if(!authenticationService.checkCandidateEmail(candidate.getEmail())) {
            s+="Email";
        }
        if(s.equals("")==false){
            s+=" has been used!!!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="/check/company")
    public ResponseEntity<String> checkCompany(@RequestBody CompanyEntity company) {
        String s = "";
        if(!authenticationService.checkCompanyEmail(company.getEmail())) {
            s+="Email";
        }
        if(!authenticationService.checkCompanyWebsite(company.getWebsite())) {
            if(!s.equals("")) s+=",";
            s+=" Website";
        }
        if(!authenticationService.checkCompanyPhone(company.getPhone())) {
            if(!s.equals("")) s+=",";
            s+=" Phone";
        }
        if(!s.equals("")){
            s+=" has been used!!!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(s);
        }
        return ResponseEntity.ok().build();
    }
}
