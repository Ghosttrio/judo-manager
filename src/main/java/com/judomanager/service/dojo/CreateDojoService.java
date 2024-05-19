package com.judomanager.service.dojo;

import com.judomanager.domain.dojo.Dojo;
import com.judomanager.repository.dojo.DojoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateDojoService {

    private final DojoRepository dojoRepository;

    @Transactional
    public void createDojo(Long masterId, String name, String location){
        Dojo dojo = Dojo.create(masterId, name, location);
        dojoRepository.save(dojo);
    }

}
