package com.judomanager.dto.dojo;

import com.judomanager.domain.dojo.DojoState;

public record UpdateDojoRequest(
        DojoState state
){}
