package com.ghosttrio.judomanager.admin.adapter.port.out.feign.board;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.board.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "BoardClient", url = "http://localhost:8000/api/v1/boards"
)
public interface BoardFeignClient {

    @GetMapping("/{boardId}")
    List<Post> findAllByBoardId(@PathVariable Long boardId);

    @DeleteMapping("/{boardId}")
    void deleteById(@PathVariable Long boardId);
}
