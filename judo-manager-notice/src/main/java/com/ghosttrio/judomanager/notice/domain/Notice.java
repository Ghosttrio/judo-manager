package com.ghosttrio.judomanager.notice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "tb_notice")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    private Long dojoId; // 도장별 공지사항을 분류하기 위한 dojoId

    private String title;
    private String content;

    public static Notice create(Long dojoId, String title, String content) {
        return new Notice(null, dojoId, title, content);
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
