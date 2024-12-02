package com.ghosttrio.judomanager.board.adapter.port.out.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "tb_post")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long id;

	private String title;
	private String content;

	private Long boardId;

	public static PostEntity create(Long boardId, String title, String content) {
		return new PostEntity(null, title, content, boardId);
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
