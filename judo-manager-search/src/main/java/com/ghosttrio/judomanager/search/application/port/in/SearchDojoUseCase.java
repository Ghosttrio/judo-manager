package com.ghosttrio.judomanager.search.application.port.in;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;

import java.util.List;

public interface SearchDojoUseCase {
    List<Dojo> execute(String name, String location, Double latitude, Double longitude);
}
