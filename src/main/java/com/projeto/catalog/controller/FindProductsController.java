package com.projeto.catalog.controller;

import com.projeto.catalog.api.FindProducts;
import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.controller.domain.ProductResponse;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.usecase.FindProductsBySellerIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FindProductsController implements FindProducts {

    private final FindProductsBySellerIdUseCase findProductsBySellerIdUseCase;

    private static ProductResponse apply(Product product) {
        return Translator.translate(product, ProductResponse.class);
    }

    @Override
    public ResponseEntity<?> execute() {
        List<ProductResponse> responseList = findProductsBySellerIdUseCase.execute().stream().map(FindProductsController::apply).collect(Collectors.toList());
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}
