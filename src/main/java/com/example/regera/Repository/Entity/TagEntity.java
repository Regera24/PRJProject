package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="value")
    private String value;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="includeTag",
            joinColumns = @JoinColumn(name="idTag"),
            inverseJoinColumns = @JoinColumn(name="idJob"))
    private List<JobEntity> jobs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<JobEntity> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobEntity> jobs) {
        this.jobs = jobs;
    }
}
