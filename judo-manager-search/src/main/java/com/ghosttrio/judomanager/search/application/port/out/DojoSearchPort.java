package com.ghosttrio.judomanager.search.application.port.out;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;

import java.util.List;

public interface DojoSearchPort {
    List<Dojo> searchName(String name, String location, Double latitude, Double longitude);

    void create(Long dojoId, String name, String dojoCode, String price,
                String location, Double latitude, Double longitude);

    List<Dojo> findNearDojo(Double latitude, Double longitude);

}
