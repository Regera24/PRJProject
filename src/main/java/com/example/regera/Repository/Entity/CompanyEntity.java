package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="companyName")
    private String companyName;

    @Column(name="phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="detail")
    private String detail;

    @Column(name="description")
    private String description;

    @Column(name="img")
    private String img;

    @Column(name="workTime")
    private String workTime;

    @Column(name="website")
    private String website;

    @Column(name="quantityPeople")
    private Integer quantityPeople;

    @OneToOne(mappedBy = "company")
    private AccountEntity account;

    @OneToMany(mappedBy = "company",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch= FetchType.LAZY)
    private List<JobEntity> jobs = new ArrayList<>();

    @OneToMany(mappedBy = "company",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch= FetchType.LAZY)
    private List<ReviewEntity> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "company",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch =  FetchType.LAZY)
    private List<NotificationEntity> notifications = new ArrayList<>();

    public String getCompanyName() {
        return companyName;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getQuantityPeople() {
        return quantityPeople;
    }

    public void setQuantityPeople(Integer quantityPeople) {
        this.quantityPeople = quantityPeople;
    }

    public List<JobEntity> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobEntity> jobs) {
        this.jobs = jobs;
    }

    public List<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public List<NotificationEntity> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationEntity> notifications) {
        this.notifications = notifications;
    }
}
