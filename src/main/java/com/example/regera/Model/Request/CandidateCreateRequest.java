package com.example.regera.Model.Request;

import com.example.regera.Repository.Entity.AccountEntity;
import com.example.regera.Repository.Entity.CandidateEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateCreateRequest {
    AccountEntity account;
    CandidateEntity candidate;
}
