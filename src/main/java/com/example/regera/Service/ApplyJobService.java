package com.example.regera.Service;

import com.example.regera.Model.ApplyJobDTO;
import com.example.regera.Model.Request.ApplyRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplyJobService {
    public List<ApplyJobDTO> getAPByCandidateId(Integer id);
    public void addApplyJob(ApplyRequest request);
}
