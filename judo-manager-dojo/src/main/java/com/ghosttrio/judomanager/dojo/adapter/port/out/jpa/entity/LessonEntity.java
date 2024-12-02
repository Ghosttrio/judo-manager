package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "tb_lesson")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LessonEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;

    private Long dojoId;
    private String name; // 강좌 이름

    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public static LessonEntity create(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime){
        return new LessonEntity(null, dojoId, name, startTime, endTime);
    }

}
