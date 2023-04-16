package com.example.sbserver.domain.record.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CreateRecordRequest {

    @NotBlank(message = "started_time은 앞글자 띄어쓰기, Null을 허용하지 않습니다")
    private LocalDateTime startedTime;

    @NotBlank(message = "finished_time은 앞글자 띄어쓰기, Null을 허용하지 않습니다")
    private LocalDateTime finishedTime;

    private String memo;
}
