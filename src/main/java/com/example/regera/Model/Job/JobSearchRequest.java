package com.example.regera.Model.Job;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JobSearchRequest {
    private String title;
    private String description;
    private Date createAt;
    private Float fromSalary;
    private Float toSalary;
    private List<Integer> cityReq = new ArrayList<>();
    private List<Integer> jobReq = new ArrayList<>();
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getCityReq() {
        return cityReq;
    }

    public void setCityReq(List<Integer> cityReq) {
        this.cityReq = cityReq;
    }

    public List<Integer> getJobReq() {
        return jobReq;
    }

    public void setJobReq(List<Integer> jobReq) {
        this.jobReq = jobReq;
    }

    public Float getToSalary() {
        return toSalary;
    }

    public void setToSalary(Float toSalary) {
        this.toSalary = toSalary;
    }

    public Float getFromSalary() {
        return fromSalary;
    }

    public void setFromSalary(Float fromSalary) {
        this.fromSalary = fromSalary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
