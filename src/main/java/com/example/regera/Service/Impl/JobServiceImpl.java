package com.example.regera.Service.Impl;

import com.example.regera.Converter.JobDTOConverter;
import com.example.regera.Model.Job.JobDTO;
import com.example.regera.Model.Job.JobSearchRequest;
import com.example.regera.Repository.CandidateRepository;
import com.example.regera.Repository.CompanyRepository;
import com.example.regera.Repository.Entity.CompanyEntity;
import com.example.regera.Repository.Entity.JobEntity;
import com.example.regera.Repository.JobRepository;
import com.example.regera.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobDTOConverter jobDTOConverter;

    @Autowired
    private CandidateRepository candidateRepository;


    @Override
    public List<JobDTO> getAllJobs() {
        List<JobEntity> list = jobRepository.findAll();
        List<JobDTO> jobDTOList = new ArrayList<>();
        for (JobEntity jobEntity : list) {
            JobDTO j = jobDTOConverter.toJobDTO(jobEntity);
            jobDTOList.add(j);
        }
        return jobDTOList;
    }

    @Override
    public List<JobDTO> getJobByRequest(JobSearchRequest jobSearchRequest) {
        List<JobEntity> list = jobRepository.getJobByRequest(jobSearchRequest);
        List<JobDTO> jobDTOList = new ArrayList<>();
        for (JobEntity jobEntity : list) {
            JobDTO j = jobDTOConverter.toJobDTO(jobEntity);
            jobDTOList.add(j);
        }
        return jobDTOList;
    }

    @Override
    public void addJob(JobEntity jobEntity) {
        jobRepository.save(jobEntity);
    }

    @Override
    public void updateJob(Integer id,JobEntity jobEntity) {
        try{
            JobEntity j = jobRepository.findById(id).get();
            Field[] fields = JobEntity.class.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                if(field.get(jobEntity)!=null){
                    field.set(j,field.get(jobEntity));
                }
            }
            jobRepository.save(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteJobs(Integer[] ids) {
        jobRepository.deleteByIdIn(ids);
    }

    @Override
    public List<JobDTO> getJobByCompnayId(Integer compnayId) {
        List<JobEntity> list = jobRepository.findByCompanyId(compnayId);
        List<JobDTO> jobDTOList = new ArrayList<>();
        for (JobEntity jobEntity : list) {
            JobDTO j = jobDTOConverter.toJobDTO(jobEntity);
            jobDTOList.add(j);
        }
        return jobDTOList;
    }

    @Override
    public List<JobDTO> getJobByCandidateId(Integer candidateId) {
        List<JobDTO> jobDTOList = new ArrayList<>();
        List<JobEntity> list = jobRepository.getJobByCandidateId(candidateId);
        for (JobEntity jobEntity : list) {
            JobDTO j = jobDTOConverter.toJobDTO(jobEntity);
            jobDTOList.add(j);
        }
        return jobDTOList;
    }

    @Override
    public JobDTO getJobById(Integer id) {
        JobEntity jobEntity = jobRepository.findById(id).get();
        JobDTO j = jobDTOConverter.toJobDTO(jobEntity);
        return j;
    }
}
