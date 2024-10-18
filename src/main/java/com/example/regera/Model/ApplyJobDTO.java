package com.example.regera.Model;

import java.sql.Date;

public class ApplyJobDTO {
    private int id;
    private Date applyAt;
    private ApplicationStatusDTO status;

    public int getId() {
        return id;
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
