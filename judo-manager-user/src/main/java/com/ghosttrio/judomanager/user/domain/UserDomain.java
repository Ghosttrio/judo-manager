package com.ghosttrio.judomanager.user.domain;

import java.time.LocalDateTime;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserRole;
import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.jpa.entity.UserState;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDomain {

	private Long id;
	private String nickname;
	private String email;
	private UserRole role;
	private UserState state;
	private LocalDateTime lastLoginDate;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Long dojoId;

	public static UserDomain createUser(String email, String nickname, UserRole role) {
		return new UserDomain(
			null,
			nickname,
			email,
			role,
			UserState.ACTIVATED,
			LocalDateTime.now(),
			LocalDateTime.now(),
			LocalDateTime.now(),
			0L); // 0L은 미등록 도장 코드
	}

	public UserDomain withDrawUser() {
		this.state = UserState.DELETED;
		this.nickname = "탈퇴유저";
		this.email = "";
		this.dojoId = 0L;
		return this;
	}

	public void updateNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setDojo(Long dojoId) {
		this.dojoId = dojoId;
	}

	public void updateLoginDate() {
		this.lastLoginDate = LocalDateTime.now();
	}

	public void updateStatus() {
		this.state = UserState.DEACTIVATED;
	}
}
