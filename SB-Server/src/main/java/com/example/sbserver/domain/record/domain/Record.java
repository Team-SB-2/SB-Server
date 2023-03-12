package com.example.sbserver.domain.record.domain;

import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.domain.user.domain.User;
import com.example.sbserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Record extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startedTime;

    @Column(nullable = false)
    private LocalDateTime finishedTime;

    @Column(nullable = false)
    private Long total;

    @Column(length = 20, nullable = false)
    private String memo;

    @JoinColumn(name = "subject_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Record(LocalDateTime startedTime, LocalDateTime finishedTime, Long total, String memo, Subject subject, User user) {
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
        this.total = total;
        this.memo = memo;
        this.subject = subject;
        this.user = user;
    }
}
