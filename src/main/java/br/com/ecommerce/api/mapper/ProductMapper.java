package br.com.ecommerce.api.mapper;

import br.com.ecommerce.api.dto.product.ProductRequestDTO;
import br.com.ecommerce.api.dto.product.ProductResponseDTO;
import br.com.ecommerce.api.model.Category;
import br.com.ecommerce.api.model.Owner;
import br.com.ecommerce.api.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO request, Category category, Owner owner) {
        return Product.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .price(request.getPrice())
            .category(category)
            .owner(owner)
            .build();
    }

    public ProductResponseDTO toDTO(Product product) {
        return ProductResponseDTO.builder()
            .id(product.getId())
            .title(product.getTitle())
            .description(product.getDescription())
            .price(product.getPrice())
            .categoryTitle(product.getCategory() != null ? product.getCategory().getTitle() : null)
            .ownerName(product.getOwner() != null ? product.getOwner().getName() : null)
            .build();
    }

    public List<ProductResponseDTO> toDTOList(List<Product> products) {
        return products.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

}
