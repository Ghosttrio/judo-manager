package com.ghosttrio.judomanager.user.application.port.out;

import com.ghosttrio.judomanager.user.adapter.port.out.infrastructure.feign.Dojo;


public interface UserClientPort {
    Dojo findDojoByDojoCode(String dojoCode);
}
