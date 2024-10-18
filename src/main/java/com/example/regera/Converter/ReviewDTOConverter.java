package com.example.regera.Converter;

import com.example.regera.Model.ReviewDTO;
import com.example.regera.Repository.Entity.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ReviewDTO toReviewDTO(ReviewEntity reviewEntity) {
        return modelMapper.map(reviewEntity, ReviewDTO.class);
    }
}
