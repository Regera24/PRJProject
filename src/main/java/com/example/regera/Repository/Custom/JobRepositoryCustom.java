package com.example.regera.Repository.Custom;

import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Repository.Entity.JobEntity;

import java.util.List;

public interface JobRepositoryCustom {
    public List<JobEntity> getJobByRequest(JobSearchRequest jobSearchRequest);
}
