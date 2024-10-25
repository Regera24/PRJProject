package com.example.regera.Repository;

import com.example.regera.Repository.Entity.ApplicationStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatusEntity, Integer> {
}
