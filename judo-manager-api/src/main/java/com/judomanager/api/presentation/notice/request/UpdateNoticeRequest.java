package com.judomanager.api.presentation.notice.request;

public record UpdateNoticeRequest(
        String title,
        String content
) {
}
