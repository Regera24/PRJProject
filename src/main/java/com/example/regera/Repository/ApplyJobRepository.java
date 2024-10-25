package com.example.regera.Repository;

import com.example.regera.Repository.Custom.ApplyJobRepositoryCustom;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Repository.Entity.applyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyJobRepository extends JpaRepository<applyJobEntity, Integer>, ApplyJobRepositoryCustom {
    public List<applyJobEntity> findByCv(CvEntity cvEntity);
}
