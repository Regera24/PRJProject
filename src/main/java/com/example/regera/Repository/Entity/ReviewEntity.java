package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="rating")
    private Integer rating;

    @Column(name="comment")
    private String comment;

    @Column(name="creatAt")
    public Date creatAt;

    @ManyToOne
    @JoinColumn(name="idCompany")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name="idCandidate")
    private CandidateEntity candidate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Date creatAt) {
        this.creatAt = creatAt;
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
