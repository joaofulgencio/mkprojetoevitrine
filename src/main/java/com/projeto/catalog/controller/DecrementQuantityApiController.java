package com.projeto.catalog.controller;

import com.projeto.catalog.api.DecrementQuantityApi;
import com.projeto.catalog.usecase.DecrementQuantityUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class DecrementQuantityApiController implements DecrementQuantityApi {

    private final DecrementQuantityUseCase decrementQuantityUseCase;

    @Override
    public void execute(String itemId) {
        decrementQuantityUseCase.execute(itemId);
    }
}
