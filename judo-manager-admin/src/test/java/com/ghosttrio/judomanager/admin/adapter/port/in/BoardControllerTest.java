package com.ghosttrio.judomanager.admin.adapter.port.in;

import com.ghosttrio.judomanager.admin.application.port.in.board.DeleteBoardUseCase;
import com.ghosttrio.judomanager.admin.application.port.in.board.LoadAllPostUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BoardControllerTest {

    @Mock
    private LoadAllPostUseCase loadAllPostUseCase;
    @Mock
    private DeleteBoardUseCase deleteBoardUseCase;
    @InjectMocks
    private BoardController boardController;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController).build();
    }

    @Test
    void 모든_게시글_조회_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(get("/api/v1/admins/boards/" + 1L + "/posts"))
                .andExpect(status().isOk());
    }

    @Test
    void 게시글_삭제_요청이_성공해야_한다() throws Exception {
        mockMvc.perform(get("/api/v1/admins/boards/" + 1L))
                .andExpect(status().isOk());
    }
}