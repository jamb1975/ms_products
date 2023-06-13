package org.product.repositorios;

import org.product.r2dbc.postgresql.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
    @Query("SELECT * FROM Product WHERE  PRODUCT_ID = :productId")
    public Mono<Product> findProductById(String productId);
}
