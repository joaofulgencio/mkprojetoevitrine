package com.projeto.catalog.usecase

import com.projeto.catalog.domain.Image
import com.projeto.catalog.domain.Product
import com.projeto.catalog.gateway.RegisterProductGateway
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain
import spock.lang.Specification

class RegisterProductUseCaseSpec extends Specification {
    RegisterProductGateway registerProductGateway = Mock(RegisterProductGateway)
    RegisterProductUseCase registerProductUseCase = new RegisterProductUseCase(registerProductGateway)

    def "Deve cadastrar um novo produto para um seller"() {
        given: "Um produto valido"
        def produtoValido = new Product(0, "Camisa", [new Image("image1.jpg"), new Image('image2.jpg')], "Camisa maneira", 40)

        when: "Eu chamo o gateway para salvar"
        1 * registerProductGateway.execute(_ as Integer, _ as Product) >> {
            args ->
                assert args[0] == 1
                Product product = args[1]
                assert product.sellerId == 0
                assert product.quantity == 40
                assert product.description == "Camisa maneira"
                assert product.productName == "Camisa"
                assert product.images[0].link == "image1.jpg"
                assert product.images[1].link == "image2.jpg"
                new ProductDatabaseDomain(1L, 1, "Camisa", ["image1.jpg", "image2.jpg"], "Camisa maneira", 40)
        }

        and: "Eu chamo o usecase de registro"
        def product = registerProductUseCase.execute(1, produtoValido)

        then: "O produto deve ser retornado"
        product.sellerId == 1
        product.productName == "Camisa"
        product.description == "Camisa maneira"
        product.quantity == 40

    }
}
