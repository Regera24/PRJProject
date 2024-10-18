package com.example.regera.API;

import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Service.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class CompanyAPI {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value="/company")
    public List<CompanyDTO> getCompany(){
        return companyService.getCompany();
    }

    @GetMapping(value="/company/{id}")
    public CompanyDTO getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }

    @PutMapping(value = "/company/{id}")
    public void updateCompany(@RequestBody CompanyEntity companyEntity,
                              @PathVariable Integer id){
        companyService.updateCompany(id, companyEntity);
    }

    @PostMapping(value = "/company")
    public void addCompany(@RequestBody CompanyEntity companyEntity){
        companyService.addCompany(companyEntity);
    }
}
