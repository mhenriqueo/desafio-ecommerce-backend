package br.com.ecommerce.api.service;

import br.com.ecommerce.api.dto.product.ProductRequestDTO;
import br.com.ecommerce.api.dto.product.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO saveProduct(ProductRequestDTO productRequest);
    List<ProductResponseDTO> getAllProducts();
    List<ProductResponseDTO> searchProductsByTitle(String title);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequest);
    void deleteProduct(Long id);
}
