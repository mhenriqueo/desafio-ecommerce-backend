package br.com.ecommerce.api.service;

import br.com.ecommerce.api.dto.category.CategoryRequestDTO;
import br.com.ecommerce.api.dto.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO saveCategory(CategoryRequestDTO categoryRequest);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO getCategoryById(Long id);
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequest);
    void deleteCategory(Long id);
}
