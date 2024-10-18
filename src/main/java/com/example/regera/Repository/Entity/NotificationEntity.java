package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="sendAt")
    private Date sendAt;

    @Column(name="message")
    private String message;

    @Column(name="role")
    private String role;

    @ManyToOne()
    @JoinColumn(name="idCompany")
    private CompanyEntity company;

    @ManyToOne()
    @JoinColumn(name="idCandidate")
    private CandidateEntity candidate;

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSendAt() {
        return sendAt;
    }

    public void setSendAt(Date sendAt) {
        this.sendAt = sendAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public CandidateEntity getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateEntity candidate) {
        this.candidate = candidate;
    }


}
