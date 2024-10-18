package com.example.regera.Model.Company;

import com.example.regera.Model.CityDTO;
import com.example.regera.Model.TagDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JobCDTO {
    private Integer id;
    private String title;
    private String luong;
    private String jobType;
    private String description;
    private Integer status;
    private Date createAt;
    private Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String salary) {
        this.luong = salary;
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

    public List<TagDTO> tagDTOList = new ArrayList<>();

    public List<TagDTO> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TagDTO> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }

    public List<CityDTO> getCityDTOList() {
        return cityDTOList;
    }

    public void setCityDTOList(List<CityDTO> cityDTOList) {
        this.cityDTOList = cityDTOList;
    }

    public List<CityDTO> cityDTOList = new ArrayList<>();
}
