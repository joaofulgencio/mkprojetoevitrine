package com.projeto.catalog.gateway.repository;

import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;

import java.util.List;

public interface ProductExtentedRepository extends ProductRepository {

    List<ProductDatabaseDomain> findBySellerId(int sellerId);
}
