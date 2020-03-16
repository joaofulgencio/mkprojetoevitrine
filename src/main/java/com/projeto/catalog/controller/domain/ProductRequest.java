package com.projeto.catalog.controller.domain;

import com.projeto.catalog.domain.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequest {

    private String name;
    private List<Image> images;
    private String description;
    private int quantity;

}
