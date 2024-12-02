package com.ghosttrio.judomanager.payment.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "tb_product")
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

    public static Product create(Long dojoId, String name, String amount){
        return new Product(null, dojoId, name, amount);
    }

}
