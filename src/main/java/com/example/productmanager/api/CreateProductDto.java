package com.example.productmanager.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CreateProductDto",
        description = "Data transfer object representing a Product creation."
)
public class CreateProductDto {

    @NotBlank
    @Size(max = 20)
    private String name;

    @Size(max = 100)
    private String description;

    @Positive()
    @NotNull
    private long price;
}
