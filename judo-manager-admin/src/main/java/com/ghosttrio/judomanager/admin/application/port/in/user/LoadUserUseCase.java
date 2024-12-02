package com.ghosttrio.judomanager.admin.application.port.in.user;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;

import java.util.List;

public interface LoadUserUseCase {
    List<User> execute();
}
