package com.ghosttrio.judomanager.admin.application.port.in.dojo.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.application.service.LoadDojoService;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoadDojoUseCaseImplTest extends MonkeySupport {

    @InjectMocks
    private LoadDojoUseCaseImpl loadDojoUseCaseImpl;
    @Mock
    private LoadDojoService loadDojoService;

    @Test
    void 모든_도장_정보_조회_서비스가_호출되어야_한다() {
        List<Dojo> dojos = monkey.giveMe(Dojo.class, 3);
        Mockito.when(loadDojoService.findAll()).thenReturn(dojos);
        loadDojoUseCaseImpl.execute();
        verify(loadDojoService, times(1)).findAll();
    }

}