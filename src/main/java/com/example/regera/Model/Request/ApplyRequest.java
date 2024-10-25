package com.example.regera.Model.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplyRequest {
    Integer cvId;
    Integer jobId;
    Date createAt;
}
