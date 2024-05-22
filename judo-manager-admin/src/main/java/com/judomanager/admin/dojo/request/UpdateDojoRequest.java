package com.judomanager.admin.dojo.request;


import com.judomanager.domain.dojo.domain.DojoState;

public record UpdateDojoRequest(
        DojoState state
){}
