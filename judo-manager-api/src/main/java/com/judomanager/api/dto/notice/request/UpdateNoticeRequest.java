package com.judomanager.api.dto.notice.request;

public record UpdateNoticeRequest(
        String title,
        String content
) {
}
