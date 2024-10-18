package com.example.regera.Model.Job;

import com.example.regera.Model.CityDTO;
import com.example.regera.Model.TagDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JobDTO {
    private Integer id;
    private String title;
    private String luong;
    private String jobType;
    private String description;
    private Integer status;
    private Date createAt;
    private Date updateAt;
    private CompanyJDTO companyJDTO;
    public List<TagDTO> tagDTOList = new ArrayList<>();
    public List<CityDTO> cityDTOList = new ArrayList<>();

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

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public CompanyJDTO getCompanyJDTO() {
        return companyJDTO;
    }

    public void setCompanyJDTO(CompanyJDTO companyJDTO) {
        this.companyJDTO = companyJDTO;
    }

    public List<CityDTO> getCityDTOList() {
        return cityDTOList;
    }

    public void setCityDTOList(List<CityDTO> cityDTOList) {
        this.cityDTOList = cityDTOList;
    }

    public List<TagDTO> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TagDTO> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }
}
