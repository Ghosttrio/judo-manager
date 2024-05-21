package com.judomanager.api.dto.board;

public record CreatePostRequest(
        String title,
        String content
) {
}
