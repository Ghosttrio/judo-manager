package com.judomanager.domain.board;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;

    private Long boardId;

    public static Post create(Long boardId, String title, String content){
        return new Post(null, title, content, boardId);
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
