package com.example.regera.Service;

import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Model.Company.CompanySearchRequest;
import com.example.regera.Repository.Entity.CompanyEntity;

import java.util.List;

public interface CompanyService {
    public List<CompanyDTO> getCompany();
    public List<CompanyDTO> getCompanyByRequest(CompanySearchRequest companySearchRequest);
    public void updateCompany(Integer id,CompanyEntity companyEntity);
    public void addCompany(CompanyEntity companyEntity);
    public CompanyDTO getCompanyById(Integer id);
}
