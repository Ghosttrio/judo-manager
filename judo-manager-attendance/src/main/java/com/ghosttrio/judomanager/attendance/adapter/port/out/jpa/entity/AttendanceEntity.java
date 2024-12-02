package com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "tb_attendance")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    private Long userId;
    private Long dojoId;

    @Enumerated
    private Approval approval;

    private LocalDateTime attendanceTime;

    public static AttendanceEntity create(Long userId, Long dojoId, LocalDateTime attendanceTime){
        return new AttendanceEntity(null, userId, dojoId, Approval.APPROVED, attendanceTime);
    }

    public void setApproval(Approval approval) {
        this.approval = Approval.APPROVED;
    }

}
