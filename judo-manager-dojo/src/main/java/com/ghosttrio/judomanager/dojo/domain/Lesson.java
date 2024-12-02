package com.ghosttrio.judomanager.dojo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Lesson {
    private Long id;
    private Long dojoId;
    private String name; // 강좌 이름
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Lesson create(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime){
        return new Lesson(null, dojoId, name, startTime, endTime);
    }
}
