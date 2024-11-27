package br.com.ecommerce.api.dto.category;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
}
