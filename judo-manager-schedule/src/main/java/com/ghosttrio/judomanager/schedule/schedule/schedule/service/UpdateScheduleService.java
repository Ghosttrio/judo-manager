//package com.ghosttrio.judomanager.schedule.schedule.schedule.service;
//
//import com.ghosttrio.judomanager.schedule.schedule.schedule.domain.Schedule;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class UpdateScheduleService {
//
//    private final LoadScheduleService loadScheduleService;
//
//    @Transactional
//    public void update(Long scheduleId, String title, String content){
//        Schedule schedule = loadScheduleService.findSchedule(scheduleId);
//        schedule.update(title, content);
//    }
//}
