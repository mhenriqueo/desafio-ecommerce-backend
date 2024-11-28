package br.com.ecommerce.api.service.impl;

import br.com.ecommerce.api.dto.product.ProductRequestDTO;
import br.com.ecommerce.api.dto.product.ProductResponseDTO;
import br.com.ecommerce.api.mapper.ProductMapper;
import br.com.ecommerce.api.model.Category;
import br.com.ecommerce.api.model.Owner;
import br.com.ecommerce.api.model.Product;
import br.com.ecommerce.api.repository.ProductRepository;
import br.com.ecommerce.api.service.ProductService;
import br.com.ecommerce.api.helper.ValidationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ValidationHelper validationHelper;

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequest) {
        Category category = validationHelper.validateCategory(productRequest.getCategoryId());
        Owner owner = validationHelper.validateOwner(productRequest.getOwnerId());

        Product product = productMapper.toEntity(productRequest, category, owner);
        Product savedProduct = productRepository.save(product);

        return productMapper.toDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTOList(products);
    }

    @Override
    public List<ProductResponseDTO> searchProductsByTitle(String title) {
        List<Product> products = productRepository.findByTitleContainingIgnoreCase(title);
        return productMapper.toDTOList(products);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = validationHelper.validateProduct(id);
        return productMapper.toDTO(product);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequest) {
        Product existingProduct = validationHelper.validateProduct(id);
        Category category = validationHelper.validateCategory(productRequest.getCategoryId());
        Owner owner = validationHelper.validateOwner(productRequest.getOwnerId());

        existingProduct.setTitle(productRequest.getTitle());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setCategory(category);
        existingProduct.setOwner(owner);

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = validationHelper.validateProduct(id);
        productRepository.delete(product);
    }
}
