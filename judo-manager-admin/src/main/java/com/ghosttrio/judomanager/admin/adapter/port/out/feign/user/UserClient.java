package com.ghosttrio.judomanager.admin.adapter.port.out.feign.user;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "UserClient", url = "http://localhost:8000/api/v1/users"
)
public interface UserClient {

    @GetMapping
    List<User> findAll();

    @PatchMapping("/status/{userId}")
    void updateUserStatus(@PathVariable Long userId);
}
