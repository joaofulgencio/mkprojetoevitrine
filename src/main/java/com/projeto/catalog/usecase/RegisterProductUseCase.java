package com.projeto.catalog.usecase;

import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.exception.RegisterProductUseCaseExeception;
import com.projeto.catalog.gateway.RegisterProductGateway;
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterProductUseCase {

    private final RegisterProductGateway registerProductGateway;

    public Product execute(String sellerId, Product product) throws RegisterProductUseCaseExeception {

        ProductDatabaseDomain execute = registerProductGateway.execute(sellerId, product);

        return Translator.translate(execute, Product.class);
    }

}
