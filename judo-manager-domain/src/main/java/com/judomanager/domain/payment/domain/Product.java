package com.judomanager.domain.payment.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private Long dojoId;
    
    private String name; // 상품명
    private String amount; // 가격
    private String month; // 개월 수

    public static Product create(Long dojoId, String name, String amount, String month){
        return new Product(null, dojoId, name, amount, month);
    }

}
