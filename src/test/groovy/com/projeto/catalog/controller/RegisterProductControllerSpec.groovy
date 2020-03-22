package com.projeto.catalog.controller

import com.google.gson.Gson
import com.projeto.catalog.controller.domain.ProductRequest
import com.projeto.catalog.controller.domain.ProductResponse
import com.projeto.catalog.domain.Image
import com.projeto.catalog.domain.Product
import com.projeto.catalog.usecase.RegisterProductUseCase
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [RegisterProductController])
class RegisterProductControllerSpec extends Specification {

    @Autowired
    protected MockMvc mockMvc

    @SpringBean
    RegisterProductUseCase registerProductUseCase = Mock(RegisterProductUseCase)


    def "Should pass request correctly to useCase"() {
        given: "a valid request"
        ProductRequest requestBody = new ProductRequest("Canmisa", [new Image("image1.jpg")], "camisa maneira", 40)
        int sellerId = 1

        Gson gson = new Gson()
        String jsonRequest = gson.toJson(requestBody)

        when: "RegisterProductUseCase execute is called"

        1 * registerProductUseCase.execute(_ as Integer, _ as Product) >> {
            return new Product(1, "Camisa", [new Image("image1.jpg")], "camisa maneira", 40)
        }


        then: "The request must be done with successful response"
        def response = mockMvc.perform(post("/catalog/{sellerId}", sellerId).content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
                .response
        ProductResponse responseObject = gson.fromJson(response.contentAsString, ProductResponse.class)
        responseObject.productName == "Camisa"
        responseObject.sellerId == 1
        responseObject.quantity == 40
        responseObject.description == "camisa maneira"
        responseObject.images.size() == 1
        responseObject.images[0].link == "image1.jpg"
    }
}
