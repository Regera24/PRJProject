package com.example.regera.Converter;

import com.example.regera.Model.NotificationDTO;
import com.example.regera.Repository.Entity.NotificationEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.Notification;

@Component
public class NotificationDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public NotificationDTO toNotificationDTO(NotificationEntity notification) {
        return modelMapper.map(notification, NotificationDTO.class);
    }

}
