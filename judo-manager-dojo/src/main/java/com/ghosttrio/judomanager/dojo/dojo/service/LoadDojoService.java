//package com.ghosttrio.judomanager.dojo.dojo.service;
//
//import com.judomanager.common.exception.ErrorCode;
//import com.judomanager.common.exception.JMException;
//import com.ghosttrio.judomanager.dojo.dojo.domain.Dojo;
//import com.ghosttrio.judomanager.dojo.dojo.repository.dojo.DojoRepository;
//import com.ghosttrio.judomanager.dojo.dojo.repository.dojo.projections.DojoCoordinateDto;
//import com.judomanager.domain.user.domain.User;
//import com.judomanager.domain.user.service.LoadUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static com.judomanager.common.exception.ErrorCode.DOJO_NOT_FOUND;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class LoadDojoService {
//
//    private final DojoRepository dojoRepository;
//    private final LoadUserService loadUserService;
//
//    public void checkDojoExist(Long dojoId){
//        dojoRepository.findById(dojoId).orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
//    }
//
//    public List<Dojo> findAll(){
//        return dojoRepository.findAll();
//    }
//
//    public List<User> findAllUserByDojoId(Long dojoId){
//        return loadUserService.findAllUserByDojoId(dojoId);
//    }
//
//    public Dojo findByDojoCode(String dojoCode){
//        return dojoRepository.findByDojoCode(dojoCode)
//                .orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
//    }
//
//
//    public DojoCoordinateDto findDojoCoordinate(Long dojoId){
//        return dojoRepository.findDojoCoordinate(dojoId);
//    }
//
//    public Dojo findByUserId(Long userId){
//        return dojoRepository.findByUserId(userId)
//                .orElseThrow(() -> new JMException(ErrorCode.DOJO_NOT_FOUND));
//    }
//}
