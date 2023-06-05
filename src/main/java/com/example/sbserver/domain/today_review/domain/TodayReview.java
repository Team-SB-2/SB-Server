package com.example.sbserver.domain.today_review.domain;

import com.example.sbserver.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class TodayReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private LocalDate date;

    public TodayReview(User user, LocalDate date) {
        this.user = user;
        this.date = date;
        this.content = null;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
