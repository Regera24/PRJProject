package com.example.regera.API;

import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CvAPI {
    @Autowired
    private CvService cvService;

    @GetMapping(value = "/cv")
    public List<CvDTO> getAllCv(){
        return cvService.getAllCv();
    }
}
