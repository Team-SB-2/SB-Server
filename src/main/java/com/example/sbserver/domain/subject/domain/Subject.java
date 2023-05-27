package com.example.sbserver.domain.subject.domain;

import com.example.sbserver.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String title;

    @ColumnDefault("'U+1F525'")
    @Column(length = 8, nullable = false)
    private String emoji;

    @ColumnDefault("1")
    @Column(nullable = false)
    private Boolean isViewable;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Subject(String title, String emoji, User user) {
        this.title = title;
        this.emoji = emoji == null ? "🔥" : emoji;
        this.isViewable = true;
        this.user = user;
    }

    public void updateIsViewable(Boolean isViewable) {
        this.isViewable = isViewable;
    }

    public void updateEmoji(String emoji) {
        if (emoji != null) {
            this.emoji = emoji;
        }
    }
}
