package com.example.sbserver.domain.record.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateRecordMemoRequest {

    @Size(max = 20, message = "memo는 20자 까지입니다.")
    private String memo;
}
