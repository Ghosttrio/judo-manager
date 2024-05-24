package com.judomanager.api.presentation.board.post.request;

public record UpdatePostRequest(
        String title,
        String content
) {
}
