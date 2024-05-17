package com.judomanager.domain.user;

import com.judomanager.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Long dojoId; // 본인이 속한 도장 id

    private String mail; // 카카오 로그인 메일

    private String deleted;

}
