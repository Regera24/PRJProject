package com.example.regera.Service;

import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Repository.Entity.CvEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CvService {
    public List<CvDTO> getAllCv();
    public List<CvDTO> getCvByJobId(Integer jobId);
    public List<CvDTO> getCvByUserId(Integer userId);
    public void addCv(CvEntity cv);
    public CvDTO getCvById(Integer id);
    public void updateCv(CvDTO cv, int id);
    public void deleteCv(Integer id);
}
