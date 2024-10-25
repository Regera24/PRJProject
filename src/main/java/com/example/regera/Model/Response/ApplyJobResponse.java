package com.example.regera.Model.Response;

import com.example.regera.Model.ApplyJobDTO;
import com.example.regera.Model.CV.CvDTO;
import com.example.regera.Model.Job.JobDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplyJobResponse {
    JobDTO job;
    CvDTO cv;
    ApplyJobDTO applyJob;
}
