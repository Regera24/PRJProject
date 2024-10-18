package com.example.regera.Converter;

import com.example.regera.Model.ApplicationStatusDTO;
import com.example.regera.Model.ApplyJobDTO;
import com.example.regera.Repository.Entity.applyJobEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToApplyJobDTO {
    @Autowired
    private ModelMapper modelMapper;

    public ApplyJobDTO toApplyJobDTO(applyJobEntity applyJob) {
        ApplyJobDTO applyJobDTO = modelMapper.map(applyJob, ApplyJobDTO.class);
        applyJobDTO.setStatus(modelMapper.map(applyJob.getApplicationStatus(), ApplicationStatusDTO.class));
        return applyJobDTO;
    }
}
