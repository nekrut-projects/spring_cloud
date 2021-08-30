package ru.gb.hystrix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.gb.dto.common.ProductDto;

import java.util.List;

//@EnableCircuitBreaker
@RestController
@RequestMapping("/client")
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @HystrixCommand(fallbackMethod = "demoFallback")
    @GetMapping("/products")
    public List<ProductDto> getAll() {
        List<ProductDto> result = restTemplate.getForObject("http://storage/products", List.class);
        return result;
    }

    @GetMapping("/products/{id}")
    public ProductDto getById(@PathVariable(name = "id") Long id) {
        ProductDto result = restTemplate.getForObject("http://storage/products/" + id, ProductDto.class);
        return result;
    }

    @DeleteMapping("/products/{id}")
    public void delById(@PathVariable(name = "id") Long id) {
        restTemplate.delete("http://storage/products/" + id);
    }

//    public String demoFallback() {
//        return "zero";
//    }

}
