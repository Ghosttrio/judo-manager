package com.judomanager.domain.dojo.service;

import com.judomanager.common.properties.OpenApiProperties;
import com.judomanager.domain.dojo.domain.Dojo;
import com.judomanager.domain.dojo.repository.dojo.DojoRepository;
import com.judomanager.infrastructure.feign.openapi.client.JudoCenterClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreateDojoService {

    private final DojoRepository dojoRepository;
    private final OpenApiProperties openApiProperties;
    private final JudoCenterClient judoCenterClient;


    @Transactional
    public void createDojo(Long masterId, String name, String location, String phone, Double latitude, Double longitude, Double radius){
        String dojoCode = generateDojoCode();
        Dojo dojo = Dojo.create(masterId, name, location, phone, dojoCode, latitude, longitude, radius);
        dojoRepository.save(dojo);
    }

    private String generateDojoCode(){
        return UUID.randomUUID().toString();
    }

    
    // todo string to json 연구
    @Transactional
    public void createAllDojo(){
//        String json = judoCenterClient.getAllDojo(
//                openApiProperties.getService_key(),
//                1,
//                1000,
//                "json",
//                "%EC%A0%95%EC%83%81%EC%9A%B4%EC%98%81",
//                "%EC%8B%A0%EA%B3%A0",
//                "%EC%B2%B4%EC%9C%A1%EB%8F%84%EC%9E%A5%EC%97%85",
//                "%EC%9C%A0%EB%8F%84"
//        );


//        ObjectMapper mapper = new ObjectMapper();
//        DojoDto dojoDto = mapper.readValue(result, DojoDto.class);
//
//        List<ItemResult> items = dojoDto.getResponse().getBody().getItems().getItem();
//
//
//        for(ItemResult item : items){
//            if(item.getFaci_lat() == null || item.getFaci_lat().equals(0)){
//                continue;
//            }
//            Address address = Address.builder()
//                    .address(item.getFaci_addr())
//                    .roadAddress(item.getFaci_road_addr())
//                    .latitude(Double.valueOf(item.getFaci_lat()))
//                    .longitude(Double.valueOf(item.getFaci_lot()))
//                    .build();
//
//            Dojo dojo = Dojo.builder()
//                    .name(item.getFaci_nm())
//                    .address(address)
//                    .phone(item.getFaci_tel_no())
//                    .build();
//            dojoRepository.save(dojo);
//        }
    }

}
