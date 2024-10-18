package com.example.regera.Converter;

import com.example.regera.Model.Company.JobCDTO;
import com.example.regera.Model.CityDTO;
import com.example.regera.Model.TagDTO;
import com.example.regera.Repository.Entity.CityEntity;
import com.example.regera.Repository.Entity.JobEntity;
import com.example.regera.Repository.Entity.TagEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobCDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TagDTOConverter tagDTOConverter;

    @Autowired
    private CityDTOConverter cityDTOConverter;

    public JobCDTO toJobCDTO(JobEntity jobEntity){
        JobCDTO jobCDTO = modelMapper.map(jobEntity, JobCDTO.class);
        jobCDTO.setLuong("$"+String.format("%.0f",jobEntity.getFromSalary())+" - "+"$"+String.format("%.0f",jobEntity.getToSalary()));
        List<TagDTO> tagDTOList = new ArrayList<>();
        List<CityDTO> cityDTOList = new ArrayList<>();
        for(TagEntity tag : jobEntity.getTags()){
            tagDTOList.add(tagDTOConverter.toTagDTO(tag));
        }
        for(CityEntity city : jobEntity.getCities()){
            cityDTOList.add(cityDTOConverter.toCityDTO(city));
        }
        jobCDTO.setTagDTOList(tagDTOList);
        jobCDTO.setCityDTOList(cityDTOList);
        System.out.println("OKK");
        return jobCDTO;
    }
}
