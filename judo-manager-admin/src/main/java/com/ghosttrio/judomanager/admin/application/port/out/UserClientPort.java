package com.ghosttrio.judomanager.admin.application.port.out;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;

import java.util.List;

public interface UserClientPort {
    List<User> findAll();

    void updateUserStatus(Long userId);
}
