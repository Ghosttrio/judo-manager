package com.ghosttrio.judomanager.search.application.port.in.impl;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;
import com.ghosttrio.judomanager.search.application.port.in.SearchNearDojoUseCase;
import com.ghosttrio.judomanager.search.application.service.SearchDojoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchNearDojoUseCaseImpl implements SearchNearDojoUseCase {

    private final SearchDojoService searchDojoService;

    @Override
    public List<Dojo> execute(Double latitude, Double longitude) {
        return searchDojoService.findNearDojo(latitude, longitude);
    }
}
