package com.example.regera.Repository;

import com.example.regera.Repository.Custom.CompanyRepositoryCustom;
import com.example.regera.Repository.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer>, CompanyRepositoryCustom {
    public CompanyEntity findByCompanyName(String companyName);
}
