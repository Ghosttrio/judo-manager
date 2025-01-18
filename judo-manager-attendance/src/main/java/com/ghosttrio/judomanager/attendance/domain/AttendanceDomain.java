package com.ghosttrio.judomanager.attendance.domain;

import com.ghosttrio.judomanager.attendance.adapter.port.out.jpa.entity.Approval;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDomain {

    private Long id;
    private Long userId;
    private Long dojoId;
    private Approval approval;
    private LocalDateTime attendanceTime;

    public static AttendanceDomain create(Long userId, Long dojoId, LocalDateTime attendanceTime){
        return new AttendanceDomain(null, userId, dojoId, Approval.APPROVED, attendanceTime);
    }

    public void setApproval(Approval approval) {
        this.approval = Approval.APPROVED;
    }

}

