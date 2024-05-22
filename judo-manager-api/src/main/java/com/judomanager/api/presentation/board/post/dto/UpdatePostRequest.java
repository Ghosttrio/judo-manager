package com.judomanager.api.presentation.board.post.dto;

public record UpdatePostRequest(
        String title,
        String content
) {
}
