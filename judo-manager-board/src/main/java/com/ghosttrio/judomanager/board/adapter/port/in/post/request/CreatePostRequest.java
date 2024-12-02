package com.ghosttrio.judomanager.board.adapter.port.in.post.request;

public record CreatePostRequest(
        String title,
        String content
) {
}
