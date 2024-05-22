package com.judomanager.infrastructure.feign;

import com.judomanager.infrastructure.config.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "OpenApiClient",
        url = "https://apis.data.go.kr/B551014/SRVC_API_SFMS_FACI",
        configuration = FeignConfig.class
)
public interface OpenApiClient {

    @GetMapping(value = "/TODZ_API_SFMS_FACI", consumes = "application/json")
    String getAllDojo(@RequestParam("serviceKey") String serviceKey,
                      @RequestParam("pageNo") int pageNo,
                      @RequestParam("numOfRows") int numOfRows,
                      @RequestParam("resultType") String resultType,
                      @RequestParam("faci_stat_nm") String faciStatNm,
                      @RequestParam("faci_gb_nm") String faciGbNm,
                      @RequestParam("fcob_nm") String fcobNm,
                      @RequestParam("ftype_nm") String ftypeNm);
}
