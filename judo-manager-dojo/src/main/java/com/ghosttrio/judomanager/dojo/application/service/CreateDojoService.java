package com.ghosttrio.judomanager.dojo.application.service;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo.DojoRepository;
import com.ghosttrio.judomanager.dojo.application.port.out.DojoJpaPort;
import com.ghosttrio.judomanager.dojo.domain.Dojo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateDojoService {

    private final DojoJpaPort dojoJpaPort;

    @Transactional
    public void createDojo(Long masterId, String name, String location, String phone, Double latitude, Double longitude, Double radius){
        String dojoCode = generateDojoCode();
        Dojo dojo = Dojo.create(null, masterId, name, location, phone, dojoCode, latitude, longitude, radius);
        dojoJpaPort.save(dojo);
    }

    private String generateDojoCode(){
        return UUID.randomUUID().toString();
    }


    // todo string to json 연구
    @Transactional
    public void createAllDojo(){
    }

}
