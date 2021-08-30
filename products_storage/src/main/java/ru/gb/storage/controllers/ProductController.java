package ru.gb.storage.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.dto.common.ProductDto;
import ru.gb.storage.exceptions.ResourceNotFoundException;
import ru.gb.storage.model.Product;
import ru.gb.storage.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return new ProductDto(p.getId(), p.getTitle(), p.getPrice());
    }

    @GetMapping
    public List<ProductDto> showPage(){
        return productService.getAll().stream().map(p->new ProductDto(p.getId(), p.getTitle(), p.getPrice())).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(null);
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Product p = productService.save(product);
        return new ProductDto(p.getId(), p.getTitle(), p.getPrice());
    }
}
