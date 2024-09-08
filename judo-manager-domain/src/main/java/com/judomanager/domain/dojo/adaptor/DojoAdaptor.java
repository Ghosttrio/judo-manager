package com.judomanager.domain.dojo.adaptor;

import com.judomanager.domain.dojo.domain.Dojo;
import com.judomanager.domain.dojo.repository.dojo.DojoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DojoAdaptor {

    private final DojoRepository dojoRepository;

    @Transactional
    public void create(Dojo dojo) {
        dojoRepository.save(dojo);
    }
}
