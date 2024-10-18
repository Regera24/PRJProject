package com.example.regera.Converter;

import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Model.Company.JobCDTO;
import com.example.regera.Model.NotificationDTO;
import com.example.regera.Model.ReviewDTO;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Repository.Entity.JobEntity;
import com.example.regera.Repository.Entity.NotificationEntity;
import com.example.regera.Repository.Entity.ReviewEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobCDTOConverter jobCDTOConverter;

    @Autowired
    private NotificationDTOConverter notificationDTOConverter;

    @Autowired
    private ReviewDTOConverter reviewDTOConverter;

    public CompanyDTO toCompanyDTO(CompanyEntity be){
        CompanyDTO companyDTO = modelMapper.map(be, CompanyDTO.class);
        List<JobCDTO> list = new ArrayList<>();
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        for(JobEntity je : be.getJobs()){
            list.add(jobCDTOConverter.toJobCDTO(je));
        }
        for(NotificationEntity ndto : be.getNotifications()){
            notificationDTOList.add(notificationDTOConverter.toNotificationDTO(ndto));
        }
        for(ReviewEntity rdto : be.getReviews()){
            reviewDTOList.add(reviewDTOConverter.toReviewDTO(rdto));
        }
        companyDTO.setReviews(reviewDTOList);
        companyDTO.setNotifications(notificationDTOList);
        companyDTO.setJobDTOList(list);
        return companyDTO;
    }
}
