package com.ghosttrio.judomanager.user.common.util;

public record ChatDto(
        Long userId,
        Long chatRoomId,
        String content
) {

}
