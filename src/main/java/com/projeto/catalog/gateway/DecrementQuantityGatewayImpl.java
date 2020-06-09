package com.projeto.catalog.gateway;

import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import com.projeto.catalog.gateway.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DecrementQuantityGatewayImpl implements DecrementQuantityGateway {
    private final ProductRepository productRepository;

    @Override
    public void execute(String itemId) {
        Optional<ProductDatabaseDomain> product = productRepository.findById(itemId);
        if (product.isPresent()) {
            if (product.get().getQuantity() > 0) {
                product.get().setQuantity(product.get().getQuantity() - 1);
                productRepository.save(product.get());
            }
        }
    }
}
