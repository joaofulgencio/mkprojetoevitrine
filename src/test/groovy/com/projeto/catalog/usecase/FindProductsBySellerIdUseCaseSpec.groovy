package com.projeto.catalog.usecase


import com.projeto.catalog.gateway.FindProductsBySellerIdGateway
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain
import spock.lang.Specification

class FindProductsBySellerIdUseCaseSpec extends Specification {

    FindProductsBySellerIdGateway findProductsBySellerIdGateway = Mock(FindProductsBySellerIdGateway)
    FindProductsBySellerIdUseCase findProductBySellerIdUseCase = new FindProductsBySellerIdUseCase(findProductsBySellerIdGateway)

    def "Deve retornar uma lista com 1 produto"() {
        given: "Um sellerId válido"
        def sellerId = "joaooctf@gmail.com"

        when: "Eu executo o gateway de busca por sellerId"
        1 * findProductsBySellerIdGateway.execute(_ as String) >> {
            args ->
                assert args[0] == "joaooctf@gmail.com"
                return productList()
        }

        and: "Eu executo o caso de uso para buscar todos os pedidos por um SellerId"
        def result = findProductBySellerIdUseCase.execute(sellerId)

        then: "Uma lista vazia deve ser retornada"
        result.size() == 1
        result[0].productName == "Camisa"
        result[0].description == "Camisa maneira"
        result[0].quantity == 40
        result[0].sellerEmail == "joaooctf@gmail.com"
        result[0].images.size() == 2
        result[0].images[0].link == "image1.jpg"
        result[0].images[1].link == "image2.jpg"

    }

    def "Deve retornar uma lista vazia quando não existem produtos cadastrados pra um sellerId especifico no banco de dados"() {
        given: "Um sellerId válido"
        def sellerId = "joaooctf@gmail.com"

        when: "Eu executo o gateway de busca por sellerId"
        1 * findProductsBySellerIdGateway.execute(_ as String) >> {
            args ->
                assert args[0] == "joaooctf@gmail.com"
                return emptyProductList()
        }

        and: "Eu executo o caso de uso para buscar todos os pedidos por um SellerId"
        def result = findProductBySellerIdUseCase.execute(sellerId)

        then: "Uma lista vazia deve ser retornada"
        result.isEmpty()
    }

    private ArrayList<ProductDatabaseDomain> productList() {
        List<ProductDatabaseDomain> productDatabaseDomainList = new ArrayList<>()
        productDatabaseDomainList.add(new ProductDatabaseDomain(1L,"joaooctf@gmail.com", "Camisa", ["image1.jpg", "image2.jpg"], "Camisa maneira", 40))
        productDatabaseDomainList
    }

    private ArrayList<ProductDatabaseDomain> emptyProductList() {
        List<ProductDatabaseDomain> productDatabaseDomainList = new ArrayList<>()
        productDatabaseDomainList
    }
}
