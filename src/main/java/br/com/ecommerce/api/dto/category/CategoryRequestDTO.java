package br.com.ecommerce.api.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDTO {
    @NotBlank(message = "O título do produto não pode ser vazio.")
    @Size(max = 100)
    private String title;

    @NotBlank(message = "A descrição do produto não pode ser vazia.")
    @Size(max = 200)
    private String description;

    @NotNull(message = "O proprietário não pode ser nulo.")
    private Long ownerId;
}
