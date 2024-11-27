package br.com.ecommerce.api.mapper;

import br.com.ecommerce.api.dto.category.CategoryRequestDTO;
import br.com.ecommerce.api.dto.category.CategoryResponseDTO;
import br.com.ecommerce.api.model.Category;
import br.com.ecommerce.api.model.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO request, Owner owner) {
        return Category.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .owner(owner)
            .build();
    }

    public CategoryResponseDTO toDTO(Category category) {
        return CategoryResponseDTO.builder()
            .id(category.getId())
            .title(category.getTitle())
            .description(category.getDescription())
            .ownerName(category.getOwner() != null ? category.getOwner().getName() : null)
            .build();
    }

    public List<CategoryResponseDTO> toDTOList(List<Category> categories) {
        return categories.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

}
