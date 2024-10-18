package com.example.regera.Service.Impl;

import com.example.regera.Converter.CvDTOConverter;
import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Repository.CvRepository;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CvServiceImpl implements CvService {

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private CvDTOConverter cvDTOConverter;

    @Override
    public List<CvDTO> getAllCv() {
        List<CvDTO> listCvDTO = new ArrayList<>();
        for(CvEntity cvEntity : cvRepository.findAll()){
            listCvDTO.add(cvDTOConverter.toCvDTO(cvEntity));
        }
        return listCvDTO;
    }
}
