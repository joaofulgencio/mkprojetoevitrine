package com.projeto.catalog.usecase;

import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.domain.Image;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.exception.RegisterProductUseCaseExeception;
import com.projeto.catalog.gateway.RegisterProductGateway;
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RegisterProductUseCase {

    private final RegisterProductGateway registerProductGateway;

    public Product execute(String sellerId, Product product) throws RegisterProductUseCaseExeception {

        ProductDatabaseDomain execute = registerProductGateway.execute(sellerId, product);
        List<Image> imageList = execute.getImages().stream().map(Image::new).collect(Collectors.toCollection(ArrayList::new));
        Product productSaved = Translator.translate(execute, Product.class);
        productSaved.setImages(imageList);

        return productSaved;
    }

}
