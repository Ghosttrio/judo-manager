package com.judomanager.api.presentation.board.post.dto;

public record CreatePostRequest(
        String title,
        String content
) {
}
