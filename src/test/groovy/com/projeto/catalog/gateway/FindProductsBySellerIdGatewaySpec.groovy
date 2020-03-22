package com.projeto.catalog.gateway

import com.projeto.catalog.gateway.domain.ProductDatabaseDomain
import com.projeto.catalog.gateway.repository.ProductExtentedRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles("test")
@SpringBootTest
@EnableJpaRepositories("com.projeto.catalog.gateway.repository")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FindProductsBySellerIdGatewaySpec extends Specification {

    @Autowired
    private ProductExtentedRepository productExtentedRepository

    FindProductsBySellerIdGatewayImpl findProductsBySellerIdGateway = new FindProductsBySellerIdGatewayImpl(productExtentedRepository)

    // Assert values based on data-h2.sql
    def "should return all products by sellerId 1"() {
        given: "a valid seller id"
        int sellerId = 1
        when: "i call find"
        List<ProductDatabaseDomain> productList = findProductsBySellerIdGateway.execute(sellerId)
        then: "the product list should be returned"
        productList.size() == 3
        productList[0].sellerId == 1
        productList[0].productName == "camisa"
        productList[0].description == "camisa maneira"
        productList[1].sellerId == 1
        productList[1].productName == "camisa 2"
        productList[1].description == "camisa maneira 2"
        productList[2].sellerId == 1
        productList[2].productName == "camisa 3"
        productList[2].description == "camisa maneira 3"
    }

    def "should return all products by sellerId 2"() {
        given: "a valid seller id"
        int sellerId = 2
        when: "i call find"
        List<ProductDatabaseDomain> productList = findProductsBySellerIdGateway.execute(sellerId)
        then: "the product list should be returned"
        productList.size() == 1
        productList[0].sellerId == 2
        productList[0].productName == "camisa"
        productList[0].description == "camisa maneira"
    }

    def "should return all products by sellerId 3"() {
        given: "a valid seller id"
        int sellerId = 3
        when: "i call find"
        List<ProductDatabaseDomain> productList = findProductsBySellerIdGateway.execute(sellerId)
        then: "the product list should be returned"
        productList.size() == 1
        productList[0].sellerId == 2
        productList[0].productName == "camisa"
        productList[0].description == "camisa maneira"
    }
}
