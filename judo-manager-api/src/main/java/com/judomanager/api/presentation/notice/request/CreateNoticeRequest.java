package com.judomanager.api.presentation.notice.request;


public record CreateNoticeRequest(
        String title,
        String content
) {
}
