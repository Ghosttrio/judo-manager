package com.ghosttrio.judomanager.notice.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    // 400 요청 오류
    METHOD_BAD_REQUEST(BAD_REQUEST, "400"),
    INVALID_ATTENDANCE_LOCATION(BAD_REQUEST, "도장에서 설정한 반경 밖에 회원이 있습니다."),
    INVALID_ATTENDANCE_TIME(BAD_REQUEST, "등록한 레슨 시간과 출석 시간이 맞지 않습니다."),
    PASS_EXPIRED(BAD_REQUEST, "회원권이 만료되었습니다."),
    PASSWORD_INCORRECT_REQUEST(BAD_REQUEST, "암호화 된 암호와 일치하지 않습니다."),

    // 401 인증 오류
    INVALID_BEARER_TOKEN(BAD_REQUEST, "유효한 Bearer 토큰의 형식이 아닙니다."),
    INVALID_SIGNATURE(BAD_REQUEST, "잘못된 서명입니다."),
    INVALID_TOKEN(BAD_REQUEST, "잘못된 토큰입니다."),
    EMPTY_TOKEN(BAD_REQUEST, "비어있는 토큰입니다."),
    EXPIRED_TOKEN(BAD_REQUEST, "만료된 토큰입니다."),
    UNSUPPORTED_TOKEN(BAD_REQUEST, "지원하지 않는 토큰입니다."),
    EXPIRED_REFRESH_TOKEN(BAD_REQUEST, "Refresh 토큰이 만료되었습니다. 다시 로그인을 시도하세요."),
    NOT_ALLOWED_URI(BAD_REQUEST, "허용되지 않은 주소입니다."),

    // 404 정보 없음 오류
    USER_NOT_FOUND(NOT_FOUND, "해당 회원이 존재하지 않습니다."),
    DOJO_NOT_FOUND(NOT_FOUND, "해당 도장이 존재하지 않습니다."),
    NOTICE_NOT_FOUND(NOT_FOUND, "해당 공지사항이 존재하지 않습니다."),
    POST_NOT_FOUND(NOT_FOUND, "해당 게시글이 존재하지 않습니다."),
    SCHEDULE_NOT_FOUND(NOT_FOUND, "해당 스케줄이 존재하지 않습니다."),
    ATTENDANCE_NOT_FOUND(NOT_FOUND, "해당 출석이 존재하지 않습니다."),
    PASS_NOT_FOUND(NOT_FOUND, "해당 회원권이 존재하지 않습니다."),
    LESSON_NOT_FOUND(NOT_FOUND, "해당 강습이 존재하지 않습니다."),
    CHAT_ROOM_NOT_FOUND(NOT_FOUND, "해당 채팅방이 존재하지 않습니다."),

    // 409 중복 오류
    USER_DUPLICATE(CONFLICT, "중복된 회원입니다."),
    NICKNAME_DUPLICATE(CONFLICT, "중복된 닉네임입니다."),
    NOTICE_TITLE_DUPLICATE(CONFLICT, "중복된 공지사항 제목입니다."),
    EMAIL_DUPLICATE(CONFLICT, "중복된 공지사항 제목입니다."),

    // 500 서버 오류
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "서버 에러 입니다. 관리자에게 문의해주세요.")
    ;

    private final HttpStatus httpStatus;
    private final String message;

}