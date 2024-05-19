package com.judomanager.dto.board;

public record CreatePostRequest(
        String title,
        String content
) {
}
