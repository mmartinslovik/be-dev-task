package com.example.productmanager.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.Instant;

@Data
@Schema(
        name = "ProductDto",
        description = "Data transfer object representing a Product."
)
public class ProductDto {

    private Long id;

    private Instant createdAt;

    @NotBlank
    @Size(max = 20)
    private String name;

    @Size(max = 100)
    private String description;

    @Positive()
    @NotNull
    private long price;
}
