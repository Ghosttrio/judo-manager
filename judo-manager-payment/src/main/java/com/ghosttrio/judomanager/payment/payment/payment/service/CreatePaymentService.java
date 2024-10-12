package com.ghosttrio.judomanager.payment.payment.payment.service;

import com.ghosttrio.judomanager.payment.payment.payment.domain.Product;
import com.ghosttrio.judomanager.payment.payment.payment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreatePaymentService {

    private final ProductRepository productRepository;

    @Transactional
    public void create(Long dojoId, String name, String amount){
        Product product = Product.create(dojoId, name, amount);
        productRepository.save(product);
    }
}
