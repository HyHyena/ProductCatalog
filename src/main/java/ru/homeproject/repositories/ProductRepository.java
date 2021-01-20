package ru.homeproject.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.homeproject.entities.ProductEntity;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);
    void deleteByName(String name);

}
