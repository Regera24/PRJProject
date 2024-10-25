package com.example.regera.API.Company;

import com.example.regera.Model.Job.JobDTO;
import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Repository.CvRepository;
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

   @GetMapping(value="/company/job")
   public List<JobDTO> getJobByCompanyId(@RequestParam int companyId){
        return jobService.getJobByCompnayId(companyId);
   }

    @PostMapping(value = "/company/job")
    public void createJob(@RequestBody JobEntity jobEntity){
        jobService.addJob(jobEntity);
    }

    @PutMapping(value = "/company/job/{id}")
    public void updateJob(@RequestBody JobEntity jobEntity,
                          @PathVariable Integer id){
        jobService.updateJob(id,jobEntity);
    }

    @DeleteMapping(value="/company/job/{id}")
    public void deleteJob(@PathVariable Integer[] ids){
        jobService.deleteJobs(ids);
    }
}
