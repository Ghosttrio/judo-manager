package com.judomanager.domain.service.schedule;

import com.judomanager.domain.repository.schedule.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeleteScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void delete(Long scheduleId){
        scheduleRepository.deleteById(scheduleId);
    }
}
