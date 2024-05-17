package com.judomanager.domain.dojo;

import com.judomanager.common.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Dojo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dojo_id")
    private Long id;

    private String name;
    private String location;
}
