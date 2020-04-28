package com.projeto.catalog.controller;

import com.projeto.catalog.api.RegisterProductApi;
import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.controller.domain.ProductRequest;
import com.projeto.catalog.controller.domain.ProductResponse;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.exception.RegisterProductUseCaseExeception;
import com.projeto.catalog.usecase.RegisterProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterProductController implements RegisterProductApi {

    private final RegisterProductUseCase registerProductUseCase;

    @Override
    public ResponseEntity<ProductResponse> execute(ProductRequest productRequest, String sellerEmail) throws RegisterProductUseCaseExeception {
        return new ResponseEntity<>(Translator.translate(registerProductUseCase.execute(sellerEmail, Translator.translate(productRequest, Product.class)), ProductResponse.class), HttpStatus.OK);
    }
}
