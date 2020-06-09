package com.projeto.catalog.gateway;

import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;

import java.util.List;

public interface FindProducts {

    List<ProductDatabaseDomain> execute();

}
