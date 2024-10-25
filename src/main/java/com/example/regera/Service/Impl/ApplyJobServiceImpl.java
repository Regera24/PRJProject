package com.example.regera.Service.Impl;

import com.example.regera.Converter.ApplyJobConverter;
import com.example.regera.Model.ApplyJobDTO;
import com.example.regera.Model.Request.ApplyRequest;
import com.example.regera.Repository.ApplicationStatusRepository;
import com.example.regera.Repository.ApplyJobRepository;
import com.example.regera.Repository.CvRepository;
import com.example.regera.Repository.Entity.CvEntity;
import com.example.regera.Repository.Entity.JobEntity;
import com.example.regera.Repository.Entity.applyJobEntity;
import com.example.regera.Repository.JobRepository;
import com.example.regera.Service.ApplyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyJobServiceImpl implements ApplyJobService {
    @Autowired
    private ApplyJobRepository applyJobRepository;

    @Autowired
    private ApplicationStatusRepository applicationStatusRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CvRepository cvRepository;

    @Autowired
    private ApplyJobConverter applyJobConverter;

    @Override
    public List<ApplyJobDTO> getAPByCandidateId(Integer id) {
        List<ApplyJobDTO> list = new ArrayList<>();
        List<applyJobEntity> applyJobEntities = applyJobRepository.getAPByCandidateId(id);
        for (applyJobEntity applyJobEntity : applyJobEntities) {
            ApplyJobDTO a = applyJobConverter.toApplyJobDTO(applyJobEntity);
            list.add(a);
        }
        return list;
    }

    @Override
    public void addApplyJob(ApplyRequest request) {
        applyJobEntity applyJobEntity = new applyJobEntity();
        CvEntity cvEntity = cvRepository.findById(request.getCvId()).get();
        JobEntity jobEntity = jobRepository.findById(request.getJobId()).get();
        applyJobEntity.setCv(cvEntity);
        applyJobEntity.setJob(jobEntity);
        applyJobEntity.setApplyAt(request.getCreateAt());
        applyJobEntity.setApplicationStatus(applicationStatusRepository.findById(1).get());
        applyJobRepository.save(applyJobEntity);
    }
}
