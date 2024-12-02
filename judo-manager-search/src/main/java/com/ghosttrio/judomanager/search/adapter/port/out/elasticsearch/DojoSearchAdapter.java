package com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Component;
import com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document.Dojo;
import com.ghosttrio.judomanager.search.application.port.out.DojoSearchPort;
import co.elastic.clients.elasticsearch._types.GeoDistanceSort;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DojoSearchAdapter implements DojoSearchPort {

	private final ElasticsearchTemplate elasticsearchTemplate;
	private final DojoRepository dojoRepository;

	/**
	 * 검색 기능 요구사항
	 * 1. 유도장 검색창 초기값은 내 주변에서 가장 가까운 유도장 3개다. done
	 * 2. 유도장을 이름으로 검색할 수 있다.
	 * - 검색 키워드에 포함되는 유도장은 모두 출력한다.
	 * - 예) '안녕' 검색 시 '안녕유도장' 출력
	 * 3. 유도장 가격, 지역, 거리 필터링 기능을 추가하여 검색할 수 있다.
	 * 4. 유도장 높은 가격순, 낮은 가격순, 가까운 거리순, 먼 거리순으로 정렬할 수 있다.
	 */

	/* 1. 유도장 검색창 초기값은 내 주변에서 가장 가까운 유도장 3개다. */
	@Override
	public List<Dojo> findNearDojo(Double latitude, Double longitude) {
		Query geoDistanceQuery = QueryBuilders.geoDistance()
			.field("pin.location")
			.distance("10km")
			.location(
				geoLocation -> geoLocation.latlon(latLonGeoLocation -> latLonGeoLocation.lon(longitude).lat(latitude)))
			.build()
			._toQuery();
		SortOptions sort = GeoDistanceSort.of(a -> a.field("pin.location")
			.location(
				geoLocation -> geoLocation.latlon(latLonGeoLocation -> latLonGeoLocation.lon(longitude).lat(latitude)))
			.order(SortOrder.Desc))._toSortOptions();
		PageRequest page = PageRequest.of(0, 3);
		NativeQuery query = new NativeQueryBuilder().withQuery(geoDistanceQuery)
			.withSort(sort)
			.withPageable(page)
			.build();

		SearchHits<Dojo> search = elasticsearchTemplate.search(query, Dojo.class);

		return search.getSearchHits().stream().map(SearchHit::getContent).toList();
	}

	@Override
	public List<Dojo> searchName(String name, String location, Double latitude, Double longitude) {
		NativeQueryBuilder queryBuilder = new NativeQueryBuilder().withQuery(QueryBuilders.wildcard(
			builder -> builder.wildcard("*" + name + "*").field("name"))); // 'name' 필드에 대한 wildcard 쿼리
		//        if (location != null && !location.isEmpty()) {
		//            queryBuilder.withFilter(QueryBuilders.term(builder -> builder.field("location").value(location))); // 'location' 필드가 존재할 때만 필터 추가
		//        }
		NativeQuery query = queryBuilder.build();
		SearchHits<Dojo> search = elasticsearchTemplate.search(query, Dojo.class);
		return search.getSearchHits().stream().map(SearchHit::getContent).toList();
	}

	@Override
	public void create(Long dojoId, String name, String dojoCode, String price, String location, Double latitude,
		Double longitude) {
		Dojo dojo = Dojo.create(dojoId, name, dojoCode, price, location, latitude, longitude);
		dojoRepository.save(dojo);
	}

}
/**
 * DELETE dojo
 *
 * get dojo
 *
 * PUT dojo/_doc/1
 * {
 *   ""
 * }
 *
 * POST /dojo/_doc/4
 * {
 *   "dojo_id": 4,
 *   "name": "d",
 *   "dojo_code": "MD001",
 *   "price": "100",
 *   "location": "Seoul, South Korea",
 *   "latitude": 37.5665,
 *   "longitude": 126.978,
 *   "pin": {
 *     "location": {
 *       "lat":30.0,
 *       "lon":100.0
 *     }
 *   }
 * }
 *
 * GET dojo/_search
 * {
 *   "query": {"geo_distance":{"pin.location":{"lat":0.0,"lon":0.0},"distance":"100000km"}},
 *   "script_fields": {
 *     "distance": {
 *       "script": {
 *         "source": "doc['pin.location'].arcDistance(params.lat, params.lon)",
 *         "params": {
 *           "lat": 0.0,
 *           "lon": 0.0
 *         }
 *       }
 *     }
 *   }
 * }
 */
//        NativeQuery query = new NativeQueryBuilder()
//                .withQuery(QueryBuilders.bool(builder -> builder.must(
//                        QueryBuilders.match(mustBuilder -> mustBuilder.field("name").query(name))
//                ))).build();
//        NativeQuery query = new NativeQueryBuilder()
//                .withQuery(QueryBuilders.wildcard(builder -> builder.wildcard("*" + name + "*").field("name")))
//                .build();
//        NativeQuery query = new NativeQueryBuilder()
//                .withQuery(QueryBuilders.wildcard(builder -> builder.wildcard("*" + name + "*").field("name")))
//                .withFilter(QueryBuilders.term(builder -> builder.field("location").value(location)))
//                .build();

//        NativeQueryBuilder queryb = new NativeQueryBuilder()
//                .withQuery(QueryBuilders.wildcard(builder -> builder.wildcard("*" + name + "*").field("name"))); // 'name' 필드에 대한 wildcard 쿼리
//
//        if (location != null && !location.isEmpty()) {
//            queryb.withFilter(QueryBuilders.term(builder -> builder.field("location").value(location))); // 'location' 필드가 존재할 때만 필터 추가
//        }
//        NativeQuery query = queryb.build();
//Query a = QueryBuilders.bool(
//        builder -> builder.must(
//                QueryBuilders.match(builder1 -> builder1.field("name").query(name))
//        ));
//    Query b = QueryBuilders.bool(
//            builder -> builder.should(
//                    QueryBuilders.match(builder1 -> builder1.field("location").query(location))
//            ));