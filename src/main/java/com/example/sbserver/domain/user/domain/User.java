package com.example.sbserver.domain.user.domain;

import com.example.sbserver.domain.record.domain.Record;
import com.example.sbserver.domain.subject.domain.Subject;
import com.example.sbserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 3)
    private Integer age;

    @Column(length = 6)
    private Sex sex;

    @Column(length = 24, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean isMarketingAgreed;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Subject> subjectList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Record> recordList;

    @Builder
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = Role.USER;
    }

    public void registerAsMember(String email, String password, String name, Integer age, Sex sex, Boolean isMarketingAgreed) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isMarketingAgreed = isMarketingAgreed;
        this.role = Role.MEMBER;
    }

    public void update(String name, Integer age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}