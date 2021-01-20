package ru.homeproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homeproject.entities.ProductEntity;
import ru.homeproject.repositories.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity saveProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    public Optional<ProductEntity> findByName(String name){
        return productRepository.findByName(name);
    }

    public Iterable<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> findById(long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void deleteProduct(ProductEntity productEntity){
        productRepository.delete(productEntity);
    }

    @Transactional
    public void deleteByName(String name){
        productRepository.deleteByName(name);
    }

}
