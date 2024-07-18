package com.judomanager.common.util;

public record ChatDto(
        Long userId,
        Long chatRoomId,
        String content
) {}