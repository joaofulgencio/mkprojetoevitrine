package com.projeto.catalog.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDatabaseDomain {

    @Id
    @GeneratedValue
    private long id;

    private int sellerId;
    private String productName;
    @ElementCollection
    private List<String> images;
    private String description;
    private int quantity;

}
