package ru.gb.product.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.product.service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

