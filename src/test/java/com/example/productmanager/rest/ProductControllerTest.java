package com.example.productmanager.rest;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.api.ProductDto;
import com.example.productmanager.facade.ProductFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductFacade productFacade;

    @Test
    void getAllProducts() throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setCreatedAt(Instant.now());
        productDto.setName("Example Product");
        productDto.setDescription("This is a sample product.");
        productDto.setPrice(50L);

        List<ProductDto> allProducts = List.of(productDto);

        when(productFacade.getAll()).thenReturn(allProducts);

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("[0].id").value(productDto.getId()))
                .andExpect(jsonPath("[0].name").value(productDto.getName()))
                .andExpect(jsonPath("[0].description").value(productDto.getDescription()))
                .andExpect(jsonPath("[0].price").value(productDto.getPrice()))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void createProduct() throws Exception {
        CreateProductDto createProductDto = new CreateProductDto();
        createProductDto.setName("New Product");
        createProductDto.setDescription("This is a new product.");
        createProductDto.setPrice(30L);

        ProductDto createdProductDto = new ProductDto();
        createdProductDto.setId(2L);
        createdProductDto.setCreatedAt(Instant.now());
        createdProductDto.setName(createProductDto.getName());
        createdProductDto.setDescription(createProductDto.getDescription());
        createdProductDto.setPrice(createProductDto.getPrice());

        when(productFacade.create(any())).thenReturn(createdProductDto);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(createProductDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(createdProductDto.getId()))
                .andExpect(jsonPath("name").value(createdProductDto.getName()))
                .andExpect(jsonPath("description").value(createdProductDto.getDescription()))
                .andExpect(jsonPath("price").value(createdProductDto.getPrice()))
                .andReturn().getResponse().getContentAsString();
    }

    private static String asJsonString(final Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
