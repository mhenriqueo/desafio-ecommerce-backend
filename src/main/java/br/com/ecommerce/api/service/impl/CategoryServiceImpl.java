package br.com.ecommerce.api.service.impl;

import br.com.ecommerce.api.dto.category.CategoryRequestDTO;
import br.com.ecommerce.api.dto.category.CategoryResponseDTO;
import br.com.ecommerce.api.mapper.CategoryMapper;
import br.com.ecommerce.api.model.Category;
import br.com.ecommerce.api.model.Owner;
import br.com.ecommerce.api.repository.CategoryRepository;
import br.com.ecommerce.api.service.CategoryService;
import br.com.ecommerce.api.helper.ValidationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ValidationHelper validationHelper;

    @Override
    public CategoryResponseDTO saveCategory(CategoryRequestDTO categoryRequest) {
        Owner owner = validationHelper.validateOwner(categoryRequest.getOwnerId());

        Category category = categoryMapper.toEntity(categoryRequest, owner);
        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toDTOList(categories);
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = validationHelper.validateCategory(id);
        return categoryMapper.toDTO(category);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequest) {
        Category existingCategory = validationHelper.validateCategory(id);
        Owner owner = validationHelper.validateOwner(categoryRequest.getOwnerId());

        existingCategory.setTitle(categoryRequest.getTitle());
        existingCategory.setDescription(categoryRequest.getDescription());
        existingCategory.setOwner(owner);

        Category updatedCategory = categoryRepository.save(existingCategory);
        return categoryMapper.toDTO(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = validationHelper.validateCategory(id);
        categoryRepository.delete(category);
    }
}
