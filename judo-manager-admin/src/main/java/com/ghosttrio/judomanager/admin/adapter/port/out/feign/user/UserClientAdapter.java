package com.ghosttrio.judomanager.admin.adapter.port.out.feign.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import com.ghosttrio.judomanager.admin.application.port.out.UserClientPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserClientAdapter implements UserClientPort {

	private final UserClient userClient;

	@Override
	public List<User> findAll() {
		return userClient.findAll();
	}

	@Override
	public void updateUserStatus(Long userId) {
		userClient.updateUserStatus(userId);
	}
}
