package com.projeto.catalog.controller;

import com.projeto.catalog.api.FindProductsBySellerIdApi;
import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.usecase.FindProductBySellerIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindProductsBySellerIdController implements FindProductsBySellerIdApi {

    private final FindProductBySellerIdUseCase findProductBySellerIdUseCase;

    @Override
    public ResponseEntity<?> execute(int sellerId) {
        return new ResponseEntity<>(Translator.translate(findProductBySellerIdUseCase.execute(sellerId), List.class), HttpStatus.OK);
    }

}
