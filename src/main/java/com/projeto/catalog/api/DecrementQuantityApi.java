package com.projeto.catalog.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/catalog")
public interface DecrementQuantityApi {

    @DeleteMapping("/{itemId}")
    void execute(@PathVariable String itemId);
}
