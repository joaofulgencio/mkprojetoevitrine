package com.projeto.catalog.controller.domain;

import com.projeto.catalog.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private int sellerId;
    private String name;
    private List<Image> images;
    private String description;
    private int quantity;

}
