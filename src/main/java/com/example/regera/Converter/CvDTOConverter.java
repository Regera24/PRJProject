package com.example.regera.Converter;

import com.example.regera.Model.ApplyJobDTO;
import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Repository.Entity.applyJobEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CvDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CvDTO toCvDTO(CvEntity cvEntity) {
        CvDTO cvDTO = modelMapper.map(cvEntity, CvDTO.class);
        List<ApplyJobDTO> applyJobDTOList = new ArrayList<>();
        for(applyJobEntity aj : cvEntity.getApplyJobEntities()){
            ApplyJobDTO applyJobDTO = modelMapper.map(aj, ApplyJobDTO.class);
            applyJobDTOList.add(applyJobDTO);
        }
        cvDTO.setApplyJobDTOList(applyJobDTOList);
        return cvDTO;
    }
}
