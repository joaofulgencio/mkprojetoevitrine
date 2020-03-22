package com.projeto.catalog.controller.domain;

import com.projeto.catalog.domain.Image;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductResponse {

    private int sellerId;
    private String productName;
    private List<Image> images;
    private String description;
    private int quantity;

}
