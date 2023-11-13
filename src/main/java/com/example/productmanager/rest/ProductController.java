package com.example.productmanager.rest;

import com.example.productmanager.api.CreateProductDto;
import com.example.productmanager.api.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(
        name = "Products",
        description = "Products API"
)
public class ProductController {

    @Operation(
            summary = "Fetch all Products.",
            description = "Returns a list of all Products."
    )
    @ApiResponse(
            responseCode = "200",
            description = "List of all Products returned successfully."
    )
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @Operation(
            summary = "Create a Product.",
            description = "Creates a new Product."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Product created successfully."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input."
                    )
            }
    )
    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody CreateProductDto createProductDto) {
        return ResponseEntity.ok(new ProductDto());
    }
}
