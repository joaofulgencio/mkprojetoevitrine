package com.projeto.catalog.usecase;

import com.projeto.catalog.gateway.DecrementQuantityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DecrementQuantityUseCase {

    private final DecrementQuantityGateway decrementQuantityGateway;

    public void execute(String itemId) {
        decrementQuantityGateway.execute(itemId);
    }

}
