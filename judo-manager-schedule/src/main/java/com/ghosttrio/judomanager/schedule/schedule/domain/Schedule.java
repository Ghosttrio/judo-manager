package com.ghosttrio.judomanager.schedule.schedule.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity(name = "tb_schedule")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;
    private Long dojoId;
    private String title;
    private String content;
    private LocalDateTime time;

    public static Schedule create(Long dojoId,
                                  String title,
                                  String content,
                                  LocalDateTime time){
        return new Schedule(
                null,
                dojoId,
                title,
                content,
                time
        );
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
