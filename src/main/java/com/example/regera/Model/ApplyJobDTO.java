package com.example.regera.Model;

import java.sql.Date;

public class ApplyJobDTO {
    private int id;
    private Date applyAt;
    private ApplicationStatusDTO status;
    private int cvId;
    private int jobId;

    public int getId() {
        return id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCvId() {
        return cvId;
    }

    public void setCvId(int cvId) {
        this.cvId = cvId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getApplyAt() {
        return applyAt;
    }

    public void setApplyAt(Date applyAt) {
        this.applyAt = applyAt;
    }

    public ApplicationStatusDTO getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatusDTO status) {
        this.status = status;
    }
}
