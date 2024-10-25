package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="applyJob")
public class applyJobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="applicationStatusId")
    private ApplicationStatusEntity applicationStatus;

    @Column(name="applyAt")
    private Date applyAt;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="idJob")
    private JobEntity job;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="idCv")
    private CvEntity cv;

    public CvEntity getCv() {
        return cv;
    }

    public void setCv(CvEntity cv) {
        this.cv = cv;
    }

    public JobEntity getJob() {
        return job;
    }

    public void setJob(JobEntity job) {
        this.job = job;
    }

    public Date getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(Date applyAt) {
        this.applyAt = applyAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationStatusEntity getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatusEntity applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
