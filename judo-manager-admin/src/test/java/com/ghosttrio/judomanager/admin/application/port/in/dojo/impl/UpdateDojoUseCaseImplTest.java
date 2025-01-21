package com.ghosttrio.judomanager.admin.application.port.in.dojo.impl;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.service.UpdateDojoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateDojoUseCaseImplTest {

    @InjectMocks
    private UpdateDojoUseCaseImpl updateDojoUseCaseImpl;
    @Mock
    private UpdateDojoService updateDojoService;

    @ParameterizedTest
    @EnumSource(DojoState.class)
    void 도장_상태_정보_수정_서비스가_호출되어야_한다(DojoState dojoState) {
        Long dojoId = 1L;
        Mockito.doNothing().when(updateDojoService).update(dojoId, dojoState);
        updateDojoUseCaseImpl.execute(dojoId, dojoState);
        verify(updateDojoService, times(1)).update(dojoId, dojoState);
    }
}