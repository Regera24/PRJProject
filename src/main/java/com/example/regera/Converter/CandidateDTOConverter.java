package com.example.regera.Converter;

import com.example.regera.Model.Candidate.CandidateDTO;
import com.example.regera.Model.NotificationDTO;
import com.example.regera.Repository.Entity.CandidateEntity;
import com.example.regera.Repository.Entity.NotificationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NotificationDTOConverter notificationDTOConverter;

    public CandidateDTO toCandidateDTO(CandidateEntity candidate) {
        CandidateDTO candidateDTO = modelMapper.map(candidate, CandidateDTO.class);
        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        for (NotificationEntity notificationEntity : candidate.getNotifications()) {
            NotificationDTO notificationDTO = notificationDTOConverter.toNotificationDTO(notificationEntity);
            notificationDTOList.add(notificationDTO);
        }
        candidateDTO.setNotifications(notificationDTOList);
        return candidateDTO;
    }
}