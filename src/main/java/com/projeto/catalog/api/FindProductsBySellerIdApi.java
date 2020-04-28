package com.projeto.catalog.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("catalog")
public interface FindProductsBySellerIdApi {

    @GetMapping(path = "/{sellerEmail}")
    ResponseEntity<?> execute(@PathVariable("sellerEmail") String sellerEmail);

}
