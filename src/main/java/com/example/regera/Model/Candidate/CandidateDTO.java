package com.example.regera.Model.Candidate;

import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Model.NotificationDTO;
import com.example.regera.Repository.Entity.AccountEntity;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Repository.Entity.NotificationEntity;
import com.example.regera.Repository.Entity.ReviewEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CandidateDTO {
    private Integer id;

    private String name;

    private String email;

    private String avartar;

    private List<NotificationDTO> notifications = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<NotificationDTO> getNotifications() {
        return notifications;
    }

    private List<CvDTO> cvs = new ArrayList<>();

    public List<CvDTO> getCvs() {
        return cvs;
    }

    public void setCvs(List<CvDTO> cvs) {
        this.cvs = cvs;
    }

    public void setNotifications(List<NotificationDTO> notifications) {
        this.notifications = notifications;
    }

    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }





}
