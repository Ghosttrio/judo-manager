package com.judomanager.domain.dojo.domain;

import com.judomanager.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dojo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dojo_id")
    private Long id;

    private Long masterId; // 관장 회원 정보

    private String name;
    private String location;

    private DojoState state; // 도장 현재 상태
    private String phone; // 관장님 전화번호

    private String dojoCode;

    public static Dojo create(Long masterId, String name, String location, String phone, String dojoCode){
        return new Dojo(null, masterId, name, location, DojoState.PENDING, phone, dojoCode);
    }

    public void updateState(DojoState state) {
        this.state = state;
    }
}
