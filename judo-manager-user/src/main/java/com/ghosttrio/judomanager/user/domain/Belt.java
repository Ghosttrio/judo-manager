package com.ghosttrio.judomanager.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<Integer, Belt> promotionMap = new HashMap<>();

    static {
        promotionMap.put(4, Belt.YELLOW);
        promotionMap.put(5, Belt.ORANGE);
        promotionMap.put(6, Belt.GREEN);
        promotionMap.put(7, Belt.BLUE);
        promotionMap.put(8, Belt.BROWN);
        promotionMap.put(13, Belt.BLACK);
        promotionMap.put(15, Belt.REA_AND_WHITE);
        promotionMap.put(17, Belt.RED);
    }

    public Belt promotion(Grade grade) {
        // 해당 grade에 맞는 Belt 반환, 없으면 현재 Belt 반환
        return promotionMap.getOrDefault(grade.ordinal(), this);
    }
}
