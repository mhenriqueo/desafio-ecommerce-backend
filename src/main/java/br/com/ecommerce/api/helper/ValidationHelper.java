package br.com.ecommerce.api.helper;

import br.com.ecommerce.api.model.Category;
import br.com.ecommerce.api.model.Owner;
import br.com.ecommerce.api.model.Product;
import br.com.ecommerce.api.repository.CategoryRepository;
import br.com.ecommerce.api.repository.OwnerRepository;
import br.com.ecommerce.api.repository.ProductRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Category validateCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada."));
    }

    public Owner validateOwner(Long ownerId) {
        return ownerRepository.findById(ownerId)
            .orElseThrow(() -> new ResourceNotFoundException("Proprietário não encontrado."));
    }

    public Product validateProduct(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado."));
    }

}
