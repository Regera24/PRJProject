package com.example.regera.Repository.Impl;

import com.example.regera.Model.Company.CompanySearchRequest;
import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Repository.Custom.JobRepositoryCustom;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Repository.Entity.JobEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JobRepositoryImpl implements JobRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public void JoinTable(StringBuilder sql, JobSearchRequest jobSearchRequest){
        if(jobSearchRequest.getJobReq()!=null && jobSearchRequest.getJobReq().size()>0){
            sql.append(" JOIN include_tag it ON it.id_job = j.id");
        }
        if(jobSearchRequest.getCityReq()!=null && jobSearchRequest.getCityReq().size()>0){
            sql.append(" JOIN include_city ic ON ic.id_job = j.id");
        }
    }

    @Override
    public List<JobEntity> getJobByRequest(JobSearchRequest jobSearchRequest) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT j.* FROM job j ");
        JoinTable(sql, jobSearchRequest);
        sql.append(" WHERE 1=1");
        if(jobSearchRequest.getStatus()!=null && jobSearchRequest.getStatus()==1){
            sql.append(" AND j.status = "+jobSearchRequest.getStatus());
        }
        if(jobSearchRequest.getTitle()!=null){
            sql.append(" AND j.title LIKE '%"+jobSearchRequest.getTitle()+"%'");
        }
        if(jobSearchRequest.getDescription()!=null){
            sql.append(" AND j.description LIKE '%"+jobSearchRequest.getDescription()+"%'");
        }
        if(jobSearchRequest.getFromSalary()!=null){
            sql.append(" AND j.from_salary >= "+jobSearchRequest.getFromSalary());
        }
        if(jobSearchRequest.getToSalary()!=null){
            sql.append(" AND j.to_salary <= "+jobSearchRequest.getToSalary());
        }
        if(jobSearchRequest.getCreateAt()!=null){
            sql.append(" AND j.create_at >= "+jobSearchRequest.getCreateAt());
        }
        if(jobSearchRequest.getJobReq()!=null && jobSearchRequest.getJobReq().size()>0){
            sql.append(" AND it.id_tag IN (" + jobSearchRequest.getJobReq().stream().map(s->s+"").collect(Collectors.joining(","))+")");
        }
        if(jobSearchRequest.getCityReq()!=null && jobSearchRequest.getCityReq().size()>0){
            sql.append(" AND ic.id_city IN (" + jobSearchRequest.getCityReq().stream().map(s->s+"").collect(Collectors.joining(","))+")");
        }
        Query query = entityManager.createNativeQuery(sql.toString(), JobEntity.class);
        return query.getResultList();
    }
}
