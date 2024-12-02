package com.ghosttrio.judomanager.search.application.port.in;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;

import java.util.List;

public interface SearchNearDojoUseCase {
    List<Dojo> execute(Double latitude, Double longitude);
}
