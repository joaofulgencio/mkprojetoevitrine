package com.projeto.catalog.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int sellerId;
    private String productName;
    private List<Image> images;
    private String description;
    private int quantity;

}
