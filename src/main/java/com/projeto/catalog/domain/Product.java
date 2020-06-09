package com.projeto.catalog.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;

    private String sellerId;
    private String sellerName;
    private String productName;
    private String images;
    private String description;
    private float price;
    private int quantity;

}
