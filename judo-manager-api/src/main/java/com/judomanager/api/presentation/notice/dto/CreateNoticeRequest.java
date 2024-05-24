package com.judomanager.api.presentation.notice.dto;

import jakarta.validation.constraints.NotNull;

public record CreateNoticeRequest(
        @NotNull String title,
        @NotNull String content
) {
}
