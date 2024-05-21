package com.judomanager.api.dto.board;

public record UpdatePostRequest(
        String title,
        String content
) {
}
