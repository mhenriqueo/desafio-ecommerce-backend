package br.com.ecommerce.api.dto.product;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String categoryTitle;
    private String ownerName;
}
