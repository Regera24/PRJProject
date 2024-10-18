package com.example.regera.Repository.Custom;

import com.example.regera.Model.Company.CompanySearchRequest;
import com.example.regera.Repository.Entity.CompanyEntity;

import java.util.List;

public interface CompanyRepositoryCustom {
    public List<CompanyEntity> getCompanyByRequest(CompanySearchRequest companySearchRequest);
}
