package com.example.regera.Service.Impl;

import com.example.regera.Converter.CompanyDTOConverter;
import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Model.Company.CompanySearchRequest;
import com.example.regera.Repository.CompanyRepository;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Service.CompanyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyDTOConverter companyDTOConverter;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CompanyDTO> getCompany() {
        List<CompanyEntity> list = companyRepository.findAll();
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for(CompanyEntity companyEntity : list){
            CompanyDTO c = companyDTOConverter.toCompanyDTO(companyEntity);
            companyDTOList.add(c);
        }
        return companyDTOList;
    }

    @Override
    public List<CompanyDTO> getCompanyByRequest(CompanySearchRequest companySearchRequest) {
        List<CompanyEntity> list = companyRepository.getCompanyByRequest(companySearchRequest);
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for(CompanyEntity companyEntity : list){
            CompanyDTO c = companyDTOConverter.toCompanyDTO(companyEntity);
            companyDTOList.add(c);
        }
        return companyDTOList;
    }

    @Override
    public void updateCompany(Integer id,CompanyEntity companyEntity) {
        try{
            CompanyEntity c = companyRepository.findById(id).get();
            Field[] fields = CompanyEntity.class.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                if(field.get(companyEntity)!=null){
                    field.set(c,field.get(companyEntity));
                }
            }
            companyRepository.save(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCompany(CompanyEntity companyEntity) {
        companyRepository.save(companyEntity);
    }

    @Override
    public CompanyDTO getCompanyById(Integer id) {
        CompanyDTO d = companyDTOConverter.toCompanyDTO(companyRepository.findById(id).get());
        return d;
    }
}
