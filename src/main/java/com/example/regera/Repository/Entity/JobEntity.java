package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="job")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="fromSalary")
    private Double fromSalary;

    @Column(name="toSalary")
    private Double toSalary;

    @Column(name="jobType")
    private String jobType;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private Integer status;

    @Column(name="createAt")
    private Date createAt;

    @Column(name="updateAt")
    private Date updateAt;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="idCompany")
    private CompanyEntity company;

    @OneToMany(mappedBy = "job", cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch =  FetchType.LAZY)
    private List<applyJobEntity> applyJobEntities = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy = "jobs")
    private List<CityEntity> cities = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE },mappedBy = "jobs")
    private List<TagEntity> tags = new ArrayList<>();

    public List<applyJobEntity> getApplyJobEntities() {
        return applyJobEntities;
    }

    public Double getFromSalary() {
        return fromSalary;
    }

    public void setFromSalary(Double fromSalary) {
        this.fromSalary = fromSalary;
    }

    public Double getToSalary() {
        return toSalary;
    }

    public void setToSalary(Double toSalary) {
        this.toSalary = toSalary;
    }

    public void setApplyJobEntities(List<applyJobEntity> applyJobEntities) {
        this.applyJobEntities = applyJobEntities;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}
