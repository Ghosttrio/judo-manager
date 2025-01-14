package com.ghosttrio.judomanager.user.application.port.out;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.model.Dojo;
import com.ghosttrio.judomanager.user.domain.Grade;


public interface UserClientPort {
    Dojo findDojoByDojoCode(String dojoCode);
}
