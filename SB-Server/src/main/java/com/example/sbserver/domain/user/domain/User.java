package com.example.sbserver.domain.user.domain;

import com.example.sbserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 3, nullable = false)
    private Integer age;

    @Column(length = 6, nullable = false)
    private Sex sex;

    @Column(length = 24, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String email, String name, Integer age, Sex sex) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.role = Role.USER;
    }

    public void update(String name, Integer age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}