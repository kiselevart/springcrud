package com.kiselevart.springcrud;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiselevart.springcrud.models.Product;
import com.kiselevart.springcrud.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public Product updateProduct(Long id, Product productDetail) {
        Product product = getProductById(id);

        product.setName(productDetail.getName());
        product.setQuantity(productDetail.getQuantity());
        product.setUnitPrice(productDetail.getUnitPrice());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
