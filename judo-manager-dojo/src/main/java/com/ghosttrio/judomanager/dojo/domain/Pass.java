package com.ghosttrio.judomanager.dojo.domain;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.PassEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Pass {
    private Long id;
    private Long userId; // 회원
    private Long lessonId; // 구입한 강습권
    private LocalDateTime expireTime; // 종료 시간

    public static Pass create(PassEntity passEntity) {
        return new Pass(passEntity.getId(), passEntity.getUserId(), passEntity.getLessonId(), passEntity.getExpireTime());
    }
}
