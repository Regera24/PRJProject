package com.example.regera.API.Public;

import com.example.regera.Model.CityDTO;
import com.example.regera.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityAPI {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city")
    public List<CityDTO> getAllCity(){
        return cityService.getAllCity();
    }
}
