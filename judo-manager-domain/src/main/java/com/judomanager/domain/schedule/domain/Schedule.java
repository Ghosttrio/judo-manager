package com.judomanager.domain.schedule.domain;

import com.judomanager.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
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


    public static Schedule create(Long dojoId, String title, String content){
        return new Schedule(null, dojoId, title, content);
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
