package com.judomanager.domain.attendance;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Attendance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    private Long userId;
    private Long dojoId;
    private LocalDateTime time;

}
