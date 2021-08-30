package ru.gb.storage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.storage.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

