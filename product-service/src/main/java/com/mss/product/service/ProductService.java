package com.mss.product.service;

import com.mss.product.dto.ProductRequest;
import com.mss.product.dto.ProductResponse;
import com.mss.product.model.Product;
import com.mss.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        product = this.productRepository.save(product);
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return this.productRepository
                .findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(),
                        product.getDescription(), product.getPrice()))
                .toList();
    }

    public ProductResponse getProductById(String productId) {
        Product product = this.productRepository
                .findById(productId).orElseThrow();
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }

}
