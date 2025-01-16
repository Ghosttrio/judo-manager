package com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity;

import com.ghosttrio.judomanager.user.domain.*;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String email; // 카카오 로그인 메일
    private UserState state;
    private LocalDateTime lastLoginDate;
    private Long dojoId; // 본인이 속한 도장 id
    @Enumerated(EnumType.STRING)
    private Belt belt;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    private String location;
    private Double latitude;
    private Double longitude;
}
