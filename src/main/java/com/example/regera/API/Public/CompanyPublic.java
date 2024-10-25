package com.example.regera.API.Public;

import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyPublic {
    @Autowired
    private CompanyService companyService;

    @GetMapping(value="/public/company/{id}")
    public CompanyDTO getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }
}
