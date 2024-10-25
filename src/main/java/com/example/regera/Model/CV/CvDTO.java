package com.example.regera.Model.CV;

import com.example.regera.Model.ApplyJobDTO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CvDTO {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String exp;
    private String description;
    private String study;
    private String linkProject;
    private String title;
    private String img;
    private String skills;
    private Date createAt;
    private Date updateAt;
    private List<ApplyJobDTO> applyJobDTOList = new ArrayList<>();

    public List<ApplyJobDTO> getApplyJobDTOList() {
        return applyJobDTOList;
    }

    public void setApplyJobDTOList(List<ApplyJobDTO> applyJobDTOList) {
        this.applyJobDTOList = applyJobDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLinkProject() {
        return linkProject;
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

    public void setLinkProject(String linkProject) {
        this.linkProject = linkProject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
