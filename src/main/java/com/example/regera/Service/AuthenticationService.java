package com.example.regera.Service;

import com.example.regera.Model.Request.AuthenticationRequest;
import com.example.regera.Model.Response.AuthenticationResponse;
import com.example.regera.Repository.Entity.AccountEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    public boolean checkAccount(String username);
    public boolean checkCompanyEmail(String email);
    public boolean checkCompanyWebsite(String website);
    public boolean checkCompanyPhone(String phone);
    public void addAccount(AccountEntity account);
    public boolean checkCandidateEmail(String email);
}
