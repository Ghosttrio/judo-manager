package com.judomanager.domain.board;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "tb_post")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;

    private Long boardId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_id")
//    private Board board;
//    @OneToMany(mappedBy = "comment")
//    private List<Comment> comments = new ArrayList<>();

    public static Post create(Long boardId, String title, String content){
        return new Post(null, title, content, boardId);
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
