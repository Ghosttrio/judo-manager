package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity;

import com.ghosttrio.judomanager.dojo.domain.Pass;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "tb_pass")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PassEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass_id")
    private Long id;
    private Long userId; // 회원
    private Long lessonId; // 구입한 강습권
    private LocalDateTime expireTime; // 종료 시간

    public static PassEntity create(Pass pass) {
        return new PassEntity(pass.getId(), pass.getUserId(), pass.getLessonId(), pass.getExpireTime());
    }
}
