package com.ghosttrio.judomanager.search.application.service;

import com.ghosttrio.judomanager.search.application.port.out.DojoSearchPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDojoIndexService {

    private final DojoSearchPort dojoSearchPort;

    public void create(Long dojoId, String name, String dojoCode, String price,
                       String location, Double latitude, Double longitude) {
        dojoSearchPort.create(dojoId, name, dojoCode, price, location, latitude, longitude);
    }
}
