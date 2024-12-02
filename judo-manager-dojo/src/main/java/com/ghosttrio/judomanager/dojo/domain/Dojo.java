package com.ghosttrio.judomanager.dojo.domain;

import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoEntity;
import com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity.DojoState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dojo {
    private Long id;
    private Long masterId; // 관장 회원 정보
    private String name;
    private String location;
    private Double latitude;
    private Double longitude;
    private Double radius; // 출석하기 위한 반경 설정 값
    private DojoState state; // 도장 현재 상태
    private String phone; // 관장님 전화번호
    private String dojoCode; // 도장 고유 코드

    public static Dojo create(Long dojoId,
            Long masterId,
                                    String name,
                                    String location,
                                    String phone,
                                    String dojoCode,
                                    Double latitude,
                                    Double longitude,
                                    Double radius){
        return new Dojo(
                dojoId,
                masterId,
                name,
                location,
                latitude,
                longitude,
                radius,
                DojoState.PENDING,
                phone,
                dojoCode
        );
    }

    public Dojo updateState(DojoState state) {
        this.state = state;
        return this;
    }
}
