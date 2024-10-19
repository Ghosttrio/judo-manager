//package com.ghosttrio.judomanager.schedule.schedule.schedule.service;
//
//import com.ghosttrio.judomanager.schedule.schedule.schedule.repository.ScheduleRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class DeleteScheduleService {
//
//    private final ScheduleRepository scheduleRepository;
//
//    @Transactional
//    public void delete(Long scheduleId){
//        scheduleRepository.deleteById(scheduleId);
//    }
//}
