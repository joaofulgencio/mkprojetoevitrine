package com.projeto.catalog.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.catalog.domain.Image;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductResponse {

    @JsonProperty("id")
    private String id;
    private String sellerId;
    @JsonProperty("name")
    private String sellerName;
    @JsonProperty("title")
    private String productName;
    @JsonProperty("img")
    private String images;
    @JsonProperty("desc")
    private String description;
    private float price;
    @JsonProperty("qtd")
    private int quantity;

}
