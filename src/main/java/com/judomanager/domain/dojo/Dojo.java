package com.judomanager.domain.dojo;

import com.judomanager.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Dojo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dojo_id")
    private Long id;

    private Long masterId; // 관장 회원 정보

    private String name;
    private String location;

    private DojoState state; // 도장 현재 상태

    public static Dojo create(Long masterId, String name, String location){
        return new Dojo(null, masterId, name, location, DojoState.PENDING);
    }

    public void updateState(DojoState state) {
        this.state = state;
    }
}
