package ru.gb.dto.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;

    public ProductDto(Long id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
