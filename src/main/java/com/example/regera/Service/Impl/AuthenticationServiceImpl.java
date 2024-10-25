package com.example.regera.Service.Impl;

import com.example.regera.Exception.AppException;
import com.example.regera.Exception.ErrorCode;
import com.example.regera.JWT.JwtTokenProvider;
import com.example.regera.Model.Request.AuthenticationRequest;
import com.example.regera.Model.Response.AuthenticationResponse;
import com.example.regera.Repository.AccountRepository;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Repository.CompanyRepository;
import com.example.regera.Repository.Entity.AccountEntity;
import com.example.regera.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println(request.getUsername());
        var account = accountRepository.findByUsername(request.getUsername())
                .orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));
        boolean authenticated = account.getPassword().equals(request.getPassword());
        if (!authenticated) throw new AppException(ErrorCode.UNAUTHENTICATED);
        var token = jwtTokenProvider.generateToken(account);
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(token);
        response.setUsername(account.getUsername());
        response.setRole(account.getRole().getCode());
        return response;
    }

    @Override
    public boolean checkAccount(String username) {
        if(accountRepository.findByUsername(username).isPresent()){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkCompanyEmail(String email) {
        if(companyRepository.findByEmail(email)!=null){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkCompanyWebsite(String website) {
        if(companyRepository.findByWebsite(website)!=null){
            return false;
        }
        return true;
    }

    @Override
    public boolean checkCompanyPhone(String phone) {
        if(companyRepository.findByPhone(phone)!=null){
            return false;
        }
        return true;
    }

    @Override
    public void addAccount(AccountEntity account) {
        accountRepository.save(account);
    }

    @Override
    public boolean checkCandidateEmail(String email) {
        if(candidateRepository.findByEmail(email)!=null){
            return false;
        }
        return true;
    }
}
