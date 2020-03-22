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

@WebMvcTest(controllers = [FindProductsBySellerIdController])
class FindProductsBySellerIdControllerSpec extends Specification {
    @Autowired
    protected MockMvc mockMvc

    @SpringBean
    FindProductsBySellerIdUseCase findProductsBySellerIdUseCase = Mock(FindProductsBySellerIdUseCase)


    def "Should return all products registered for a specific user"() {
        given: "a valid request"
        int sellerId = 1

        when: "findProductsBySellerIdUseCase execute is called"

        1 * findProductsBySellerIdUseCase.execute(_ as Integer) >> {
            return [new Product(1, "Camisa", [new Image("image1.jpg")], "camisa maneira", 40),
                    new Product(1, "Camisa 2", [new Image("image1.jpg"), new Image("image2.jpg")], "camisa maneira 2", 20)]
        }


        then: ""
        Gson gson = new Gson()
        def response = mockMvc.perform(get("/catalog/{sellerId}", sellerId).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
                .response
        Type listType = new TypeToken<ArrayList<ProductResponse>>() {}.getType()
        List<ProductResponse> responseObject = gson.fromJson(response.contentAsString, listType)
        responseObject[0].name == "Camisa"
        responseObject[0].sellerId == 1
        responseObject[0].quantity == 40
        responseObject[0].description == "camisa maneira"
        responseObject[0].images.size() == 1
        responseObject[0].images[0].link == "image1.jpg"
        responseObject[1].name == "Camisa 2"
        responseObject[1].sellerId == 1
        responseObject[1].quantity == 20
        responseObject[1].description == "camisa maneira 2"
        responseObject[1].images.size() == 2
        responseObject[1].images[0].link == "image1.jpg"
        responseObject[1].images[1].link == "image2.jpg"
    }
}
