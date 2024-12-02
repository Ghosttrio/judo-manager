package com.ghosttrio.judomanager.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Admin {
	private Long id;
	private String adminId;
	private String password;
	private String nickname;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
