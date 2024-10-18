package com.example.regera.Service.Impl;

import com.example.regera.Converter.CityDTOConverter;
import com.example.regera.Model.CityDTO;
import com.example.regera.Repository.CityRepository;
import com.example.regera.Repository.Entity.CityEntity;
import com.example.regera.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityDTOConverter cityDTOConverter;

    @Override
    public List<CityDTO> getAllCity() {
        List<CityDTO> cityDTOList = new ArrayList<>();
        List<CityEntity> cityEntities = cityRepository.findAll();
        for (CityEntity cityEntity : cityEntities) {
            CityDTO c = cityDTOConverter.toCityDTO(cityEntity);
            cityDTOList.add(c);
        }
        return cityDTOList;
    }
}
