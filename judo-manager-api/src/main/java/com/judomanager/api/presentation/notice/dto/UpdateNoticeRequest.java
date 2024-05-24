package com.judomanager.api.presentation.notice.dto;

public record UpdateNoticeRequest(
        String title,
        String content
) {
}
