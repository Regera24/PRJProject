package com.example.regera.Repository;

import com.example.regera.Repository.Custom.JobRepositoryCustom;
import com.example.regera.Repository.Entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, Integer>, JobRepositoryCustom {
    public void deleteByIdIn(Integer[] ids);
    public List<JobEntity> findByCompanyId(Integer id);
}
