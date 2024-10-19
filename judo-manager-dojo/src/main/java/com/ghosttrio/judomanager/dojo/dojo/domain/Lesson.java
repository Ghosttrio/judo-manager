//package com.ghosttrio.judomanager.dojo.dojo.domain;
//
//import com.judomanager.domain.common.BaseEntity;
//import jakarta.persistence.*;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity(name = "tb_lesson")
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class Lesson extends BaseEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "lesson_id")
//    private Long id;
//
//    private Long dojoId;
//    private String name; // 강좌 이름
//
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;
//
//
//    public static Lesson create(Long dojoId, String name, LocalDateTime startTime, LocalDateTime endTime){
//        return new Lesson(null, dojoId, name, startTime, endTime);
//    }
//
//}
