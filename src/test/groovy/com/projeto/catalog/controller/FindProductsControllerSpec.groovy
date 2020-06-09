package com.projeto.catalog.controller

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.projeto.catalog.controller.domain.ProductResponse
import com.projeto.catalog.domain.Image
import com.projeto.catalog.domain.Product
import com.projeto.catalog.usecase.FindProductsBySellerIdUseCase
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import java.lang.reflect.Type

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [FindProductsController])
class FindProductsControllerSpec extends Specification {
    @Autowired
    protected MockMvc mockMvc

    @SpringBean
    FindProductsBySellerIdUseCase findProductsBySellerIdUseCase = Mock(FindProductsBySellerIdUseCase)


    def "Should return all products registered for a specific user"() {
        given: "a valid request"
        def sellerId = "joaooctf@gmail.com"

        when: "findProductsBySellerIdUseCase execute is called"

        1 * findProductsBySellerIdUseCase.execute(_ as String) >> {
            return [new Product("joaooctf@gmail.com", "Camisa", [new Image("image1.jpg")], "camisa maneira", 20, 40),
                    new Product("joaooctf@gmail.com", "Camisa 2", [new Image("image1.jpg"), new Image("image2.jpg")], "camisa maneira 2", 15, 40)]
        }


        then: "the request must be done with successful response"
        Gson gson = new Gson()
        def response = mockMvc.perform(get("/catalog/{sellerId}", sellerId).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
                .response
        Type listType = new TypeToken<ArrayList<ProductResponse>>() {}.getType()
        List<ProductResponse> responseObject = gson.fromJson(response.contentAsString, listType)
        responseObject[0].productName == "Camisa"
        responseObject[0].quantity == 40
        responseObject[0].price == 20
        responseObject[0].description == "camisa maneira"
        responseObject[0].images.size() == 1
        responseObject[0].images[0].link == "image1.jpg"
        responseObject[1].productName == "Camisa 2"
        responseObject[1].sellerEmail == "joaooctf@gmail.com"
        responseObject[1].quantity == 40
        responseObject[1].price == 15
        responseObject[1].description == "camisa maneira 2"
        responseObject[1].images.size() == 2
        responseObject[1].images[0].link == "image1.jpg"
        responseObject[1].images[1].link == "image2.jpg"
    }
}
