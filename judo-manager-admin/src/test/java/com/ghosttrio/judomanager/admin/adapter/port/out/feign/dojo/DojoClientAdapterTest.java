package com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.common.MonkeySupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DojoClientAdapterTest extends MonkeySupport {

    @Mock
    private DojoFeignClient dojoFeignClient;
    @InjectMocks
    private DojoClientAdapter dojoClientAdapter;

    @Test
    void 도장_정보_전체조회_요청이_성공해야_한다() {
        List<Dojo> dojos = monkey.giveMe(Dojo.class, 3);
        when(dojoFeignClient.findAll()).thenReturn(dojos);
        dojoClientAdapter.findAll();
        verify(dojoFeignClient, times(1)).findAll();
    }

    @ParameterizedTest
    @EnumSource(DojoState.class)
    void 도장_정보_수정_요청이_성공해야_한다(DojoState dojoState) {
        Long dojoId = 1L;
        doNothing().when(dojoFeignClient).update(dojoId, dojoState);
        dojoClientAdapter.update(dojoId, dojoState);
        verify(dojoFeignClient, times(1)).update(dojoId, dojoState);
    }
}