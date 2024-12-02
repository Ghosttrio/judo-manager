package com.ghosttrio.judomanager.board.adapter.port.in.post.request;

public record UpdatePostRequest(
        String title,
        String content
) {
}
