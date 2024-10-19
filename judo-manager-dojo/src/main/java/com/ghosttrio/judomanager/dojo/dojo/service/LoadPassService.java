//package com.ghosttrio.judomanager.dojo.dojo.service;
//
//import com.ghosttrio.judomanager.dojo.dojo.domain.Pass;
//import com.judomanager.common.exception.ErrorCode;
//import com.judomanager.common.exception.JMException;
//import com.ghosttrio.judomanager.dojo.dojo.repository.pass.PassRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import static com.judomanager.common.exception.ErrorCode.PASS_NOT_FOUND;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class LoadPassService {
//
//    private final PassRepository passRepository;
//
//
//    public Pass loadLessonByUserId(Long userId){
//        return passRepository.findByUserPass(userId)
//                .orElseThrow(() -> new JMException(ErrorCode.PASS_NOT_FOUND));
//    }
//
//
//}
