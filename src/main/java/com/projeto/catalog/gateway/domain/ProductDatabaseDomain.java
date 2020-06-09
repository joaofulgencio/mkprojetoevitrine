package com.projeto.catalog.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDatabaseDomain {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sellerId;
    private String sellerEmail;
    private String productName;
    private String images;
    private String description;
    private float price;
    private int quantity;

}
