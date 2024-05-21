package com.judomanager.api.dto.dojo;


import com.judomanager.domain.domain.dojo.DojoState;

public record UpdateDojoRequest(
        DojoState state
){}
