package com.projeto.catalog.usecase;

import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.domain.Image;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.gateway.FindProducts;
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindProductsBySellerIdUseCase {

    private final FindProducts findProducts;

    public List<Product> execute() {
        List<ProductDatabaseDomain> execute = findProducts.execute();
        List<Product> productList = new ArrayList<>();
        execute.forEach(product -> {
            Product productTranslated = Translator.translate(product, Product.class);
            productList.add(productTranslated);
        });

        return productList;
    }
}
