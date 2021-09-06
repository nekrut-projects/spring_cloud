package ru.gb.product.service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.product.service.model.Product;
import ru.gb.product.service.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }


    public List<Product> getAll(){
        return Collections.unmodifiableList(productRepository.findAll());
    }
}
