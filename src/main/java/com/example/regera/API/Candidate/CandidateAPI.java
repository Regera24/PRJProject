package com.example.regera.API.Candidate;

import com.example.regera.Model.ApplyJobDTO;
import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Model.Candidate.CandidateDTO;
import com.example.regera.Model.Company.CompanyDTO;
import com.example.regera.Model.Job.JobDTO;
import com.example.regera.Model.Request.ApplyRequest;
import com.example.regera.Model.Response.ApplyJobResponse;
import com.example.regera.Repository.AccountRepository;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Repository.Entity.AccountEntity;
import com.example.regera.Repository.Entity.CandidateEntity;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Repository.JobRepository;
import com.example.regera.Service.ApplyJobService;
import com.example.regera.Service.CandidateService;
import com.example.regera.Service.CvService;
import com.example.regera.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CandidateAPI {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CvService cvService;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ApplyJobService applyJobService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;


    @GetMapping(value="/candidate/info/{username}")
    public CandidateDTO getCandidateByUsername(@PathVariable String username) {
        return candidateService.getCandidateByAccount(username);
    }

    @GetMapping(value = "/candidate/{id}")
    public CandidateDTO getCandidateById(@PathVariable int id) {
        return candidateService.getCandidateById(id);
    }

    @PutMapping(value = "/candidate/{id}")
    public ResponseEntity<String> updateCandidate(@PathVariable int id, @RequestBody CandidateEntity candidateEntity) {
        candidateService.updateCandidate(candidateEntity, id);
        return ResponseEntity.ok().body("Successfully change candidate");
    }

    @GetMapping(value="/candidate/cv")
    public List<CvDTO> getCVByUserId(@RequestParam Integer candidateId){
        return cvService.getCvByUserId(candidateId);
    }

    @PostMapping(value="/candidate/cv/{username}")
    public ResponseEntity<String> addCV(@PathVariable String username, @RequestBody CvEntity cvEntity) {
        CandidateEntity candidate = candidateRepository.findByAccount(accountRepository.findByUsername(username).get());
        cvEntity.setCandidate(candidate);
        System.out.println(cvEntity.getName());
        cvService.addCv(cvEntity);
        return ResponseEntity.ok().body("Successfully added candidate");
    }

    @PutMapping(value="/candidate/cv/{id}")
    public ResponseEntity<String> updateCV(@PathVariable int id, @RequestBody CvDTO cvDTO) {
        cvService.updateCv(cvDTO,id);
        return ResponseEntity.ok().body("Successfully update candidate");
    }

    @GetMapping(value="/candidate/cv/{id}")
    public CvDTO getCVById(@PathVariable int id) {
        return cvService.getCvById(id);
    }

    @GetMapping(value="/candidate/appliedjob/{id}")
    public List<ApplyJobDTO> getAppliedJob(@PathVariable int id) {
        List<ApplyJobDTO> applyJobDTOList = applyJobService.getAPByCandidateId(id);
//        List<ApplyJobResponse> applyJobResponseList = new ArrayList<>();
//        for (ApplyJobDTO applyJobDTO : applyJobDTOList) {
//            JobDTO j = jobService.getJobById(applyJobDTO.getJobId());
//            CvDTO cv = cvService.getCvById(applyJobDTO.getCvId());
//            ApplyJobResponse applyJobResponse = new ApplyJobResponse();
//            applyJobResponse.setJob(j);
//            applyJobResponse.setCv(cv);
//            applyJobResponse.setApplyJob(applyJobDTO);
//            applyJobResponseList.add(applyJobResponse);
//        }
        return applyJobDTOList;
    }

    @DeleteMapping(value="/candidate/cv/{id}")
    public ResponseEntity<String> deleteCV(@PathVariable int id) {
        cvService.deleteCv(id);
        return ResponseEntity.ok().body("Successfully delete candidate");
    }

    @PostMapping(value="/candidate/apply")
    public ResponseEntity<String> applyJob(@RequestBody ApplyRequest request) {
        applyJobService.addApplyJob(request);
        return ResponseEntity.ok().body("Successfully apply job");
    }
}
