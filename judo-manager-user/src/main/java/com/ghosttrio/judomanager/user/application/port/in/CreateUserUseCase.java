package com.ghosttrio.judomanager.user.application.port.in;


import com.ghosttrio.judomanager.user.adapter.port.in.presentation.model.request.UserRequest.Create.CreateUserServiceRequest;

public interface CreateUserUseCase {
    void execute(CreateUserServiceRequest request);
}
