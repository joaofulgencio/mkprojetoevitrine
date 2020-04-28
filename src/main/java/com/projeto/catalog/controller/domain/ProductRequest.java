package com.projeto.catalog.controller.domain;

import com.projeto.catalog.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String productName;
    private List<Image> images;
    private String description;
    private double price;
    private int quantity;

}
