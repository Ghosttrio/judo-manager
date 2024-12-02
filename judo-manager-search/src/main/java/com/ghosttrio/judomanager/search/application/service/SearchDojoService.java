package com.ghosttrio.judomanager.search.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;
import com.ghosttrio.judomanager.search.application.port.out.DojoSearchPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchDojoService {

	private final DojoSearchPort dojoSearchPort;

	public List<Dojo> searchName(String name, String location, Double latitude, Double longitude) {
		return dojoSearchPort.searchName(name, location, latitude, longitude);
	}

	public List<Dojo> findNearDojo(Double latitude, Double longitude) {
		return dojoSearchPort.findNearDojo(latitude, longitude);
	}

}
