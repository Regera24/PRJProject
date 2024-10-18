package com.example.regera.Converter;

import com.example.regera.Model.CityDTO;
import com.example.regera.Repository.Entity.CityEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CityDTO toCityDTO(CityEntity cityEntity){
        return modelMapper.map(cityEntity, CityDTO.class);
    }
}
