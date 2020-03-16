package com.projeto.catalog.gateway.repository;

import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDatabaseDomain, String> {
}
