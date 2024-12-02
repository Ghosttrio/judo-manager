package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.dojo;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;

public interface DojoCommandRepository {
    void update(Long dojoId, DojoState state);
}
