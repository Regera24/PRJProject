package com.example.regera.Service.Impl;

import com.example.regera.Converter.TagDTOConverter;
import com.example.regera.Model.TagDTO;
import com.example.regera.Repository.Entity.TagEntity;
import com.example.regera.Repository.TagRepository;
import com.example.regera.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagDTOConverter tagDTOConverter;

    @Override
    public List<TagDTO> getAllTag() {
        List<TagDTO> list = new ArrayList<>();
        List<TagEntity> tagEntityList = tagRepository.findAll();
        for (TagEntity tagEntity : tagEntityList) {
            TagDTO tagDTO = tagDTOConverter.toTagDTO(tagEntity);
            list.add(tagDTO);
        }
        return list;
    }
}
