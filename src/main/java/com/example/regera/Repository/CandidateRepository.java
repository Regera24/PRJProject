package com.example.regera.Repository;

import com.example.regera.Repository.Entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer> {

}
