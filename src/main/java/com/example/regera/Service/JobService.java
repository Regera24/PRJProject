package com.example.regera.Service;

import com.example.regera.Model.Job.JobDTO;
import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Repository.Entity.JobEntity;

import java.util.List;

public interface JobService {
    public List<JobDTO> getAllJobs();
    public List<JobDTO> getJobByRequest(JobSearchRequest jobSearchRequest);
    public void addJob(JobEntity jobEntity);
    public void updateJob(Integer id,JobEntity jobEntity);
    public void deleteJobs(Integer[] ids);
    public List<JobDTO> getJobByCompnayId(Integer compnayId);
    public List<JobDTO> getJobByCandidateId(Integer candidateId);
    public JobDTO getJobById(Integer id);
}
