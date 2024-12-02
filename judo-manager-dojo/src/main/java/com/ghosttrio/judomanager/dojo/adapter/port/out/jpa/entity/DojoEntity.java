package com.ghosttrio.judomanager.dojo.adapter.port.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "tb_dojo")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DojoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dojo_id")
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

    public static DojoEntity create(Long masterId,
                                    String name,
                                    String location,
                                    String phone,
                                    String dojoCode,
                                    Double latitude,
                                    Double longitude,
                                    Double radius){
        return new DojoEntity(
                null,
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

    public void updateState(DojoState state) {
        this.state = state;
    }
}
