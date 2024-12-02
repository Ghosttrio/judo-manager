package com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.GeoPointField;

public record Pin(
	@GeoPointField
	Location location
) {
}
