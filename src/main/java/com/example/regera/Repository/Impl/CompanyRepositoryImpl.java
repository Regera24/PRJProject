package com.example.regera.Repository.Impl;

import com.example.regera.Model.Company.CompanySearchRequest;
import com.example.regera.Repository.Custom.CompanyRepositoryCustom;
import com.example.regera.Repository.Entity.CompanyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CompanyRepositoryImpl  implements CompanyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CompanyEntity> getCompanyByRequest(CompanySearchRequest companySearchRequest) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT c.* FROM company c WHERE 1=1");
        try{
            Field[] fields = CompanySearchRequest.class.getDeclaredFields();
            for(Field item : fields){
                item.setAccessible(true);
                String fieldName = item.getName();
                if(item.get(companySearchRequest)!=null){
                    String value = (String)item.get(companySearchRequest);
                    sql.append(" AND " + fieldName +" LIKE " + "'%"+value+"%'");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Query query = entityManager.createNativeQuery(sql.toString(), CompanyEntity.class);
        return query.getResultList();
    }
}
