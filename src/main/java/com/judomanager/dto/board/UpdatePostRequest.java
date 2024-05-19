package com.judomanager.dto.board;

public record UpdatePostRequest(
        String title,
        String content
) {
}
