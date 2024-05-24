package com.judomanager.api.presentation.board.post.request;

public record CreatePostRequest(
        String title,
        String content
) {
}
