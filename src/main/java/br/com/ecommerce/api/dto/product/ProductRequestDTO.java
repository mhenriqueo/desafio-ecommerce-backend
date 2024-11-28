package br.com.ecommerce.api.dto.product;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    @NotBlank(message = "O título do produto não pode ser vazio.")
    @Size(max = 100)
    private String title;

    @NotBlank(message = "A descrição do produto não pode ser vazia.")
    @Size(max = 200)
    private String description;

    @NotNull(message = "O preço do produto não pode ser nulo.")
    @Positive(message = "O preço do produto deve ser maior que zero.")
    private Double price;

    @NotNull(message = "A categoria não pode ser nula.")
    private Long categoryId;

    @NotNull(message = "O proprietário não pode ser nulo.")
    private Long ownerId;
}
