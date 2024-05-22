package com.judomanager.admin.dojo;


import com.judomanager.domain.dojo.domain.DojoState;

public record UpdateDojoRequest(
        DojoState state
){}
