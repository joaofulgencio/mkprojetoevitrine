package com.projeto.catalog.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @JsonProperty("title")
    private String productName;
    @JsonProperty("img")
    private String images;
    @JsonProperty("desc")
    private String description;
    private double price;
    private int quantity;

}
