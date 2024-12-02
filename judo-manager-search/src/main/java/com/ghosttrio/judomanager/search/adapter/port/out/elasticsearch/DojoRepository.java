package com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;

public interface DojoRepository extends ElasticsearchRepository<Dojo, String> {
}
