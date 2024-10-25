package com.example.regera.API.Public;

import com.example.regera.Model.TagDTO;
import com.example.regera.Service.TagService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class TagAPI {

    @Autowired
    private TagService tagService;

    @GetMapping(value = "/tag")
    public List<TagDTO> getAllTag(){
        return tagService.getAllTag();
    }
}
