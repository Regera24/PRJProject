package com.example.regera.Repository.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="applicationStatus")
public class ApplicationStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="value")
    private String value;

    @OneToMany(mappedBy="applicationStatus", fetch = FetchType.LAZY)
    private List<applyJobEntity> applyJobEntityList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<applyJobEntity> getApplyJobEntityList() {
        return applyJobEntityList;
    }

    public void setApplyJobEntityList(List<applyJobEntity> applyJobEntityList) {
        this.applyJobEntityList = applyJobEntityList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
