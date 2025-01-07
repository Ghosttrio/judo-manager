package com.ghosttrio.judomanager.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Belt {
    WHITE("흰띠"),
    YELLOW("노란띠"),
    ORANGE("주황띠"),
    GREEN("초록띠"),
    BLUE("파란띠"),
    BROWN("밤띠"),
    BLACK("검은띠"),
    REA_AND_WHITE("용띠"),
    RED("빨간띠");
    private final String beltName;

}
