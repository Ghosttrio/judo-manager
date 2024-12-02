package com.ghosttrio.judomanager.search.application.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;
import com.ghosttrio.judomanager.search.application.port.in.SearchDojoUseCase;
import com.ghosttrio.judomanager.search.application.service.SearchDojoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchDojoUseCaseImpl implements SearchDojoUseCase {

	private final SearchDojoService searchDojoService;

	@Override
	public List<Dojo> execute(String name, String location, Double latitude, Double longitude) {
		return searchDojoService.searchName(name, location, latitude, longitude);
	}
}
