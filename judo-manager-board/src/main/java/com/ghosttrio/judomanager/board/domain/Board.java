package com.ghosttrio.judomanager.board.domain;

public record Board(
	Long id,
	String name
) {
	public static Board create(Long id, String name) {
		return new Board(id, name);
	}
}
