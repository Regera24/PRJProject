package com.example.regera.API.Public;

import com.example.regera.Model.Job.JobDTO;
import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Service.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class JobAPIPublic {
    @Autowired
    private JobService jobService;

    @GetMapping(value="/job/all")
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping(value="/job/{id}")
    public JobDTO getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @PostMapping(value="/job/similar")
    public List<JobDTO> getSimilarJobs(@RequestBody JobSearchRequest request) {
        return jobService.getJobByRequest(request);
    }

    @PostMapping(value = "/job")
    public List<JobDTO> getJobsByRequest(@RequestBody JobSearchRequest jobSearchRequest){
        return jobService.getJobByRequest(jobSearchRequest);
    }
}
