package ru.homeproject.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.homeproject.entities.ProductEntity;
import ru.homeproject.services.ProductService;

import java.util.Optional;

@RestController
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/check")
    public String lifeCheck(){
        return "You have reached product controller";
    }

    @PostMapping(value = "/saveProduct")
    public ProductEntity saveUser(@RequestBody ProductEntity productEntity){
        log.info("Saving user " + productEntity);
        return productService.saveProduct(productEntity);
    }

    @GetMapping("/getByName")
    public Optional<ProductEntity> getByName(@RequestBody ProductEntity productEntity){
        log.info("Getting user by: " + productEntity.getName());
        return productService.findByName(productEntity.getName());
    }

    @GetMapping("/getAll")
    public Iterable<ProductEntity> getAll(){
        return productService.findAll();
    }

    @DeleteMapping("/deleteByName")
    public void deleteByName(@RequestBody ProductEntity productEntity){
        log.info("Deleting user by: " + productEntity.getName());
        productService.deleteByName(productEntity.getName());
    }

        @PostMapping("/updateDescription")
    public ProductEntity updateDescription(@RequestBody ProductEntity productEntity){
        log.info("Updating description: " + productEntity.getDescription());
        Optional<ProductEntity> productEntity1 = productService.findByName(productEntity.getName());
        productEntity1.ifPresent(entity -> entity.setDescription(productEntity.getDescription()));
        return productEntity1.map(productService::saveProduct).orElse(null);
    }

}
