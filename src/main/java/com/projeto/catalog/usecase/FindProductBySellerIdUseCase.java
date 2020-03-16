package com.projeto.catalog.usecase;

import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.domain.Image;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.gateway.FindProductsBySellerIdGateway;
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindProductBySellerIdUseCase {

    private final FindProductsBySellerIdGateway findProductsBySellerIdGateway;

    public List<Product> execute(int sellerId) {
        List<ProductDatabaseDomain> execute = findProductsBySellerIdGateway.execute(sellerId);
        List<Product> productList = new ArrayList<>();
        execute.forEach(product -> {
            Product productTranslated = Translator.translate(product, Product.class);
            List<Image> imageList = product.getImages().stream().map(Image::new).collect(Collectors.toCollection(ArrayList::new));
            productTranslated.setImages(imageList);
            productList.add(productTranslated);
        });

        return productList;
    }
}
