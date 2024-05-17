package com.judomanager.domain.attendance;

import com.judomanager.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Attendance extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;
}
