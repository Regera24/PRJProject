package com.example.regera.Converter;

import com.example.regera.Model.TagDTO;
import com.example.regera.Repository.Entity.TagEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public TagDTO toTagDTO(TagEntity tagEntity){
        return modelMapper.map(tagEntity, TagDTO.class);
    }

}
