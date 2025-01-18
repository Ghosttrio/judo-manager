package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghosttrio.judomanager.admin.adapter.port.in.model.UpdateDojoRequest;
import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;
import com.ghosttrio.judomanager.admin.application.port.in.dojo.LoadDojoUseCase;
import com.ghosttrio.judomanager.admin.application.port.in.dojo.UpdateDojoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class DojoControllerTest {

    @Mock
    private UpdateDojoUseCase updateDojoUseCase;
    @Mock
    private LoadDojoUseCase loadDojoUseCase;
    @InjectMocks
    private DojoController dojoController;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(dojoController).build();
    }

    @Test
    void 모든_도장_조회_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(get("/api/v1/admins/dojos"))
                .andExpect(status().isOk());
    }

    @Test
    void 등록_요청_도장의_승인_거절_요청이_성공해야_한다() throws Exception {
        UpdateDojoRequest request = new UpdateDojoRequest(DojoState.APPROVAL);

        mockMvc.perform(patch("/api/v1/admins/dojos/" + 1L + "/state")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

}