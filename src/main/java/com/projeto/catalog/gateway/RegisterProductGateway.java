package com.projeto.catalog.gateway;

import com.projeto.catalog.domain.Product;
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;

public interface RegisterProductGateway {

    ProductDatabaseDomain execute(String sellerEmail, Product product);
}
