package com.judomanager.api.dto.notice.request;

import jakarta.validation.constraints.NotNull;

public record CreateNoticeRequest(
        @NotNull String title,
        @NotNull String content
) {
}
