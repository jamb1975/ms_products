package org.product.r2dbc.postgresql.gateways;


import org.product.r2dbc.postgresql.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductAdapterRepository {


    public Mono<Product> findProductById(String productId);
    public Flux<Product> findAllProducts();
    public Mono<Product> create(Product product);
    public Mono<Product> update(Product product);
    public Mono<Void> delete(String productId);

}
