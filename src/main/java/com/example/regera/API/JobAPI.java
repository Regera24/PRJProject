package com.example.regera.API;

import com.example.regera.Model.Job.JobDTO;
import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Repository.Entity.JobEntity;
import com.example.regera.Service.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class JobAPI {
    @Autowired
    private JobService jobService;

    @GetMapping(value = "/job")
    public List<JobDTO> getJobsByRequest(@RequestBody JobSearchRequest jobSearchRequest){
        return jobService.getJobByRequest(jobSearchRequest);
    }

    @PostMapping(value = "/job")
    public void createJob(@RequestBody JobEntity jobEntity){
        jobService.addJob(jobEntity);
    }

    @PutMapping(value = "/job/{id}")
    public void updateJob(@RequestBody JobEntity jobEntity,
                          @PathVariable Integer id){
        jobService.updateJob(id,jobEntity);
    }

    @DeleteMapping(value="/job/{id}")
    public void deleteJob(@PathVariable Integer[] ids){
        jobService.deleteJobs(ids);
    }
}
