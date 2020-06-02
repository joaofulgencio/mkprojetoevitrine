package com.projeto.catalog.api;

import com.projeto.catalog.controller.domain.ProductRequest;
import com.projeto.catalog.controller.domain.ProductResponse;
import com.projeto.catalog.exception.RegisterProductUseCaseExeception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("catalog")
public interface RegisterProductApi {

    @PostMapping(path = "/{sellerId}")
    ResponseEntity<ProductResponse> execute(@RequestBody ProductRequest productRequest, @PathVariable("sellerId") String sellerId) throws RegisterProductUseCaseExeception;
}
