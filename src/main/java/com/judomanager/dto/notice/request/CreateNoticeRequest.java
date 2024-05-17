package com.judomanager.dto.notice.request;

import jakarta.validation.constraints.NotNull;

public record CreateNoticeRequest(
        @NotNull String title,
        @NotNull String content
) {
}
