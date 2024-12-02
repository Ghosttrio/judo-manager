package com.ghosttrio.judomanager.admin.application.port.in.dojo;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;

import java.util.List;

public interface LoadDojoUseCase {
    List<Dojo> execute();
}
