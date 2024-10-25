package com.example.regera.API.Company;

import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Service.CompanyService;
import com.example.regera.Service.CvService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class CompanyAPI {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CvService cvService;

    @GetMapping(value="/company/info/{username}")
    public CompanyDTO getCompanyByUsername(@PathVariable String username) {
        return companyService.getCompanyByAccount(username);
    }


    @GetMapping(value="/company")
    public List<CompanyDTO> getCompany(){
        return companyService.getCompany();
    }

    @GetMapping(value="/company/cv")
    public List<CvDTO> getCVByJobId(@RequestParam Integer jobId){
        return cvService.getCvByJobId(jobId);
    }

    @GetMapping(value="/company/{id}")
    public CompanyDTO getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }

    @PutMapping(value = "/company/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody CompanyEntity companyEntity,
                                        @PathVariable Integer id){
        companyService.updateCompany(id, companyEntity);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/company")
    public void addCompany(@RequestBody CompanyEntity companyEntity){
        companyService.addCompany(companyEntity);
    }
}
