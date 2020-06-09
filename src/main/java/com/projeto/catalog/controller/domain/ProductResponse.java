package com.projeto.catalog.controller.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {

    @JsonProperty("id")
    private int id;
    private String sellerId;
    private String sellerEmail;
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
