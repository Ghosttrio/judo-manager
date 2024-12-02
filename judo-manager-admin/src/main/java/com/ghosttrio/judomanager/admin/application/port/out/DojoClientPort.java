package com.ghosttrio.judomanager.admin.application.port.out;

import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.Dojo;
import com.ghosttrio.judomanager.admin.adapter.port.out.feign.dojo.model.DojoState;

import java.util.List;


public interface DojoClientPort {
    List<Dojo> findAll();

    void update(Long dojoId, DojoState state);
}
