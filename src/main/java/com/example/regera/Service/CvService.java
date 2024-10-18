package com.example.regera.Service;

import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Repository.Entity.CvEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvService {
    public List<CvDTO> getAllCv();
}
